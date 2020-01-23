package com.biz.gallery.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.gallery.service.FileService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/testImage")
public class TestImageController {
	private final FileService fileService;
	
	 @PostMapping("/image")
	    @ResponseBody
	    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
	        try {
	            String uploadFileName=fileService.file_up(file);
	            return ResponseEntity.ok().body("/image/" + fileService.getId());
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.badRequest().build();
	        }
	    }
}
