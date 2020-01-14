package com.biz.rbooks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.ReadBookVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/rbook")
@RequiredArgsConstructor
@Slf4j
public class ReadBookController {
	
	/*
	 * 입력 화면을 보여주기 위한 method
	 */
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		ReadBookVO rBookVO=new ReadBookVO();
		model.addAttribute("rBookVO", rBookVO);
		return "rbooks/input";
	}
}
