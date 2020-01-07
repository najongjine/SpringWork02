package com.biz.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.service.FileService;
import com.biz.gallery.service.ImageFileService;
import com.biz.gallery.service.ImageServiceV2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/rest")
public class ImgRestController {
	protected final FileService fService;
	protected final ImageFileService ifService;
	protected final ImageServiceV2 imService;
	
	@Autowired
	public ImgRestController(FileService fService, ImageFileService ifService,ImageServiceV2 imService) {
		super();
		this.fService = fService;
		this.ifService = ifService;
		this.imService=imService;
	}

	@RequestMapping(value = "/file_up",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String file_up(@RequestParam("file") MultipartFile upfile) {
		String uploadFileName=fService.file_up(upfile);
		if(uploadFileName==null) {
			return "FAIL";
		} else {
			return uploadFileName;
		}
	}
	
	@RequestMapping(value = "/image_delete",method=RequestMethod.POST)
	public String img_delete(@RequestParam("img_id") String img_id) {
		try {
			ImageFilesVO imgsVO=ifService.findBySeq(img_id);
			log.debug("!!!시퀀스로 잘 찾음");
			fService.file_delete(imgsVO.getImg_file_upload_name());
			log.debug("!!!실제파일 잘 지움");
			ifService.img_file_delete(img_id);
			log.debug("!!!DB에서 잘 지움");
			imService.setMainImage(imgsVO);
			log.debug("!!!메인 이미지 잘 셋팅함");
		} catch (Exception e) {
			// TODO: handle exception
			return "FAIL";
		}
		return "OK";
	}
}
