package com.biz.gallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.repository.ImageDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("imgServiceV1")
public class ImageService {
	/*
	 * 기존방법:setter 주입방식
	 * 
	 * @autow 클래스 객체
	 */
	protected final ImageDao imDao;
	protected final FileService fService;
	protected final ImageFileService ifService;

	/*
	 * 생성자에서 객체 주입사용하는 객체를 final로 선언해서 보호할수있고 혹시모를 해킹에 의한 데이터 변조를 막을수 있다. 클래스의 교차참조를
	 * 컴파일러 차원에서 방지할수 있다.
	 * 
	 * intellij에선 setter 주입방식을 사용하면 ide가 심각한 경고를 보인다.
	 */
	@Autowired
	public ImageService(ImageDao imDao, FileService fService, ImageFileService ifService) {
		super();
		this.imDao = imDao;
		this.fService = fService;
		this.ifService = ifService;
	}

	public List<ImageVO> selectAll() {
		return imDao.selectAll();
	}

	public int insert(ImageVO imageVO) {
		// 1. 파일 이름 리스트를 추출
		List<String> fileList = imageVO.getImg_file_upload_name();
		
		//2.리스트가 있는지 검사하여 플래그 셋팅
		boolean yesList=fileList != null && fileList.size()>0;
		
		// 3.리스트가 있는지 검사
		if (yesList) {

			// 4. 0번 파일을 대표 파일로 지정
			imageVO.setImg_file(imageVO.getImg_file_upload_name().get(0));

		}

		// 5 tbl_gallery에 본문 insert
		int ret = imDao.insert(imageVO);
		long img_p_code = imageVO.getImg_seq();
		// 4.리스트가 있는지 검사
		
		// 6. 파일이름을 저장하기 위해서 리스트를 생성
		List<ImageFilesVO> files=new ArrayList<ImageFilesVO>();
		
		// 7.다시 리스트가 있는지 검사
		if (yesList) {

			// 8 파일 이름을 DB에 저장하기 위한 list를 작성
			for (String fileName : fileList) {
				files.add(ImageFilesVO.builder().img_file_upload_name(fileName)
						.img_file_p_code(img_p_code)
						.img_file_origin_name(fileName.substring(36)).build());
			}
			// 9 파일정보를 tbl_images에 bulk insert
			ifService.imageFileInsert(files, img_p_code);
		}

		log.debug(imageVO.toString());

		return ret;
	}

	/*
	 * 일반적으로 doa.insert(vo)를 호출했을때 vo에 담아서 전달한 값은 insert가 수행된 후에 볼수 있으나 seq처럼 sql에서
	 * 생성된 값은 확인이 불가능. 그런데 이 값을 insert 후에 사용해야할 경우가 있다. 이땐 dao나 mapper에 selectkey를
	 * 사용해서 값을 생성하면 insert후에 그 값을 사용할수 있다.
	 */
	public int insert(ImageVO imageVO, String dummy) {
		List<String> fileList = imageVO.getImg_file_upload_name();

		// 여러개의 파일중 0번 파일을 대표 파일로 업로드
		if (fileList != null && fileList.size() > 0) {
			imageVO.setImg_file(imageVO.getImg_file_upload_name().get(0));
		}

		// 1 tbl_gallery에 데이터 insert
		int ret = imDao.insert(imageVO);

		// 2. 파일이름들을 imagefilesVO의 리스트 생성
		// ImageFilesVO에 imgFile_p_code 칼럼에 tbl_gallery의 seq값을 추가해서 리스트 생성
		List<ImageFilesVO> files = new ArrayList<ImageFilesVO>();
		if (fileList != null) {
			for (String fileName : fileList) {
				files.add(ImageFilesVO.builder().img_file_upload_name(fileName).img_file_p_code(imageVO.getImg_seq())
						.build());
			}
			// 3 파일정보를 tbl_images에 insert
			ifService.imageFileInsert(files, imageVO.getImg_seq());
		}

		log.debug(imageVO.toString());
		return ret;
	}

	public ImageVO findBySeq(String img_seq) {
		// TODO Auto-generated method stub
		ImageVO imgVO = imDao.findBySeq(img_seq);
		log.debug(imgVO.toString());
		return imgVO;
	}

	/*
	 * 혹시 파일이 변경이 되면 기존파일을 먼저 제거하고 새로운 파일로 등록
	 */
	public int update(ImageVO imageVO) { // 여기엔 seq만 같고 내용은 틀린 새로운 VO가 넘어옴
		// findbyseq는 예전 vo
		long img_seq=imageVO.getImg_seq();
		String img_file=imageVO.getImg_file();
		ImageVO imgVO=imDao.findBySeqAndFile(img_seq, img_file);
		if(imgVO==null) {
			ImageVO oldimgVO = imDao.findBySeq(img_seq + "");
			if(oldimgVO.getImg_file() != null) {
				fService.file_delete(oldimgVO.getImg_file());
			}
		}
		List<String> fileNames=imageVO.getImg_file_upload_name();
		if(fileNames!=null && fileNames.size() > 0) {
			List<ImageFilesVO> files =new ArrayList<ImageFilesVO>();
			for(String fileName:fileNames) {
				ImageFilesVO vo=ImageFilesVO.builder().img_file_origin_name(fileName.substring(36))
						.img_file_upload_name(fileName).build();
				files.add(vo);
			}
			ifService.imageFileInsert(files, imageVO.getImg_seq());
		}
		
		int ret = imDao.update(imageVO);
		return ret;
	}

	public int delete(String img_seq) {
		// TODO Auto-generated method stub
		ImageVO imgVO = imDao.findBySeq(img_seq);
		if (imgVO.getImg_file() != null) {
			fService.file_delete(imgVO.getImg_file());
		}
		for(ImageFilesVO imgsVO:imgVO.getImg_files()) {
			fService.file_delete(imgsVO.getImg_file_upload_name());
		}
		return imDao.delete(img_seq);
	}

	public List<ImageFilesVO> files_up(MultipartHttpServletRequest mFiles) {
		List<ImageFilesVO> fileNames = new ArrayList<ImageFilesVO>();
		for (MultipartFile file : mFiles.getFiles("files")) {
			// 개별 파일은 하나씩 컴터에 업로드하고 이름을 리턴받음
			ImageFilesVO imVO = ImageFilesVO.builder().img_file_origin_name(file.getOriginalFilename())
					.img_file_upload_name(fService.file_up(file)).build();
			fileNames.add(imVO);
		}
		return fileNames;
	}

}
