package com.biz.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.biz.gallery.service.FileService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/rest")
public class ImgRestController {
	@Autowired
	FileService fService;
	
	@RequestMapping(value = "/file_up",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	public String file_up(@RequestParam("file") MultipartFile upfile) {
		String uploadFileName=fService.file_up(upfile);
		if(uploadFileName==null) {
			return "FAIL";
		} else {
			return uploadFileName;
		}
	}
}
