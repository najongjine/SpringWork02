package com.biz.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.pet.domain.CommentDTO;
import com.biz.pet.service.CommentService;

// 병원 상세페이지에 후기댓글 추가를 위해한 controller
@RequestMapping(value="/comment")
@Controller
public class CommentController {

	@Autowired
	CommentService cService;
	
	@RequestMapping(value="write", method=RequestMethod.POST, produces="application/json;charset=UTF-8")
	public List<CommentDTO> writeComment(
			@RequestParam(value="contentid", required=false, defaultValue="1") String contentId,
			@RequestParam(value="writer", required=false, defaultValue="1") String c_writer,
			@RequestParam(value="text", required=false, defaultValue="1") String c_text, Model model){
		
		model.addAttribute("contentid", contentId);
		
		int ret = cService.insertComment(contentId, c_writer, c_text);
		List<CommentDTO> commentList = cService.viewCommentList(contentId);
		return commentList;
	}
}
