package com.biz.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.repository.ImageDao;
import com.biz.gallery.repository.ImageFilesDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("imgServiceV3")
public class ImageServiceV3 extends ImageServiceV2{
	
	@Autowired
	public ImageServiceV3(ImageDao imDao, FileService fService, ImageFileService ifService, ImageFilesDao imgsDao) {
		super(imDao, fService, ifService, imgsDao);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insert(ImageVO imageVO) {
		imageVO=updateImageFiles(imageVO);
		int ret=imDao.insert(imageVO);
		long img_pcode=imageVO.getImg_seq();
		ifService.imageFileInsert(imageVO.getImg_files(),img_pcode);
		return ret;
	}

	@Override
	public int update(ImageVO imageVO) {
		int ret=0;
		imageVO=updateImageFiles(imageVO);
		ret=imDao.update(imageVO);
		long img_pcode=imageVO.getImg_seq();
		ifService.imageFileInsert(imageVO.getImg_up_files(), img_pcode);
		
		return ret;
	}
	
	protected ImageVO updateImageFiles(ImageVO imageVO) {
		List<ImageFilesVO> imgFiles=imageVO.getImg_up_files();
		if(imgFiles!=null && imgFiles.size()>0) {
			imageVO.setImg_file(imgFiles.get(0).getImg_file_upload_name());
			for(ImageFilesVO ifVO:imgFiles) {
				ifVO.setImg_file_origin_name(ifVO.getImg_file_upload_name().substring(36));
			}
		}
		return imageVO;
	}
	
}
