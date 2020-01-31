package com.biz.todo.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.todo.service.EncService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequiredArgsConstructor
public class HomeController {
	private final EncService encService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/testenc",produces = "application/json; charset=utf8")
	public String testenc() {
		String str=encService.encString("가ㅇㅇㅎㄱㅎㄱ");
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value = "/testdec",produces = "application/json; charset=utf8")
	public String testdec() {
		String str=encService.encString("가ㅇㅇㅎㄱㅎㄱ");
		str=encService.decString(str);
		return str;
	}
	
}
