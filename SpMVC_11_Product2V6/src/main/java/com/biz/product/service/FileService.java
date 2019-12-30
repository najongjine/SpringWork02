package com.biz.product.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.product.domain.ProFileDTO;
import com.biz.product.persistence.FileDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileService {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	String winFilePath;
	@Autowired
	String macFilePath;
	
	String fileUpLoadPath;
	FileDao fileDao;
	/*
	 * macFilePath를 검사하여 path가 존재하면 파일 업로드를 macFilePath로 변경하고
	 * 그렇지 않으면 winFilePath를 업로드 폴더로 쓰겠다.
	 */
	@Autowired
	public void fileUpPath() {
<<<<<<< HEAD
		fileUpLoadPath=winFilePath;
		File path=new File(macFilePath);
		if(path.exists()){
			fileUpLoadPath=macFilePath;
=======
		fileUpLoadPath=macFilePath;
		File path=new File(winFilePath);
		if(path.exists()){
			fileUpLoadPath=winFilePath;
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
		}
	}
	
	@Autowired
	public void fileDao() {
		fileDao=sqlSession.getMapper(FileDao.class);
	}

	/*
	 * 여러개의 파일들을 개별파일로 분리하여 fileUp()에게 보내서 파일을 업로드 하도록 하고 fileUp이 생성한 업로드 파일이름을
	 * return받아서 List에 추가한후 파일이름들을 controller로 return.
	 */
	public List<ProFileDTO> filesUp(MultipartHttpServletRequest u_files) {
		if(u_files.getFile("u_files").getSize()<1) return null;
		List<ProFileDTO> upFileList = new ArrayList<ProFileDTO>();
		/*
		 * 개별파일 업로드중 문제가 발생하면 controlter에 null값 리턴
		 */
		try {
			for (MultipartFile file : u_files.getFiles("u_files")) {
				//파일 업로드하고 파일명 받기
				//upFileName=UUID+originalFileName
				String upFileName = fileUp(file);
				ProFileDTO pf=ProFileDTO.builder().file_origin_name(file.getOriginalFilename())
						.file_upload_name(upFileName).build();
						upFileList.add(pf);
			}
		} catch (Exception e) {
			log.debug("Exception: "+e.getMessage());
			return null;
		}

		return upFileList;
	}

	public String fileUp(MultipartFile u_file) throws Exception {
		// 업로드된 파일정보에서 파일이름만 추출
		String originName = u_file.getOriginalFilename();

		// tomcat server가 작동되고있는 곳에대한 정보
		// getRealPath("/"):= tomcat server가 우리 프로젝트를 서비스할때
		// root로 설정하여 여러가지 정보를 저장하고있는 폴더정보

		if (u_file != null) {
			// /files/ 폴더에대한 IO 정보를 추출
			File dir = new File(fileUpLoadPath);

			// 현재 서버에 /files/라는 폴더가 없으면
			if (!dir.exists()) {
<<<<<<< HEAD
=======
				if(dir.mkdirs()) {
					log.debug("폴더 생성 OK");
				} else {
					fileUpLoadPath=macFilePath;
				}
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
				dir.mkdirs();
			}
			// original 파일이름을 사용을 하면 해킹사고를 일으킬수 있기 때문에
			// 파일 이름을 UUID로 설정하여 DB 테이블에 저장하자
			String strUUID = UUID.randomUUID().toString();
			strUUID += originName;
			// uploadName+originName;
			// /product/files/2019.jpg 라는 이름으로 파일명을 만들고
			// 해당하는 파일에대한 정보를 객체로 생성하라
			File uploadFile = new File(fileUpLoadPath, strUUID);

			// web에서 upload된 파일(u_file)을 방금 설정한 파일이름(uploadFile)에 전송하라
			// web >> server로 파일이 복사가 된다.
			try {
				// u_file을 uploadFile로 복사하라
				// uploadFile로 저장하라
				u_file.transferTo(uploadFile);

				// 파일이 정상적으로 upload가 되면 originalName을 controller로 return할 것이다.
				return strUUID;
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return null;
	}

	public void fileDelete(String p_file) {
		// TODO Auto-generated method stub
		File dFile = new File(fileUpLoadPath, p_file);
		if (dFile.exists()) {
			boolean ok = dFile.delete();
			if (ok) {
				log.debug("파일 삭제성공");
			} else {
				log.debug("파일삭제 실패");
			}
		} else {
			log.debug("삭제할 파일이 없음");
		}
	}

	public ProFileDTO findByFileSeq(String file_seq) {
		// TODO Auto-generated method stub
		return fileDao.findByFileSeq(file_seq);
	}
<<<<<<< HEAD
=======

	public List<ProFileDTO> getFiles(String p_code) {
		return fileDao.findByPCode(p_code);
	}
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
}
