package com.biz.todo.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.todo.domain.TestVO;
import com.biz.todo.respository.TestDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {
	private final TestDao tDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(TestVO testVO, Model model) {
		tDao.insert(testVO);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(TestVO testVO,Model model) {
		List<TestVO> testList=tDao.selectAll();
		log.debug("!!!"+testList.toString());
		model.addAttribute("List", testList);
		return "/list";
	}
	
}
