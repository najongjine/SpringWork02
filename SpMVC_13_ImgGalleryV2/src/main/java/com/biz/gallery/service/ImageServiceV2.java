package com.biz.gallery.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.repository.ImageDao;
import com.biz.gallery.repository.ImageFilesDao;

@Service("imgServiceV2")
public class ImageServiceV2 extends ImageService{
	protected final ImageFilesDao imgsDao;
	@Autowired
	public ImageServiceV2(ImageDao imDao, FileService fService, ImageFileService ifService,ImageFilesDao imgsDao) {
		super(imDao, fService, ifService);
		this.imgsDao=imgsDao;
	}

	@Override
	public int update(ImageVO imageVO) {
		int ret=0;
		List<String> fileNames=imageVO.getImg_file_upload_name();
		if(fileNames!=null && fileNames.size() >0) {
			imageVO.setImg_file(fileNames.get(0));
			List<ImageFilesVO> files=new ArrayList<ImageFilesVO>();
			for(String fileName:fileNames) {
				files.add(ImageFilesVO.builder().img_file_origin_name(fileName.substring(36))
						.img_file_upload_name(fileName).img_file_p_code(imageVO.getImg_seq())
						.build()
						);
			}
			ifService.imageFileInsert(files, imageVO.getImg_seq());
		}
		ret=imDao.update(imageVO);
		return ret;
	}
	
	public void setMainImage(ImageVO imgVO) {
		List<ImageFilesVO> imgsVOList=imgsDao.findByPCode(imgVO.getImg_seq());
		if(imgsVOList!=null && imgsVOList.size()>0) {
			imgVO.setImg_file(imgsVOList.get(0).getImg_file_upload_name());
		}
	}
	public void setMainImage(ImageFilesVO imgsVO) {
		String img_seq=imgsVO.getImg_file_p_code()+"";
		ImageVO imgVO=imDao.findBySeq(img_seq);
		List<ImageFilesVO> imgsVOList=imgsDao.findByPCode(imgVO.getImg_seq());
		if(imgsVOList!=null && imgsVOList.size()>0) {
			imgVO.setImg_file(imgsVOList.get(0).getImg_file_upload_name());
		}
	}
}
