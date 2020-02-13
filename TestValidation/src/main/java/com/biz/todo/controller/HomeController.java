package com.biz.todo.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.todo.domain.TestVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("testVO", new TestVO());
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(@Valid @ModelAttribute("testVO") TestVO testVO, Errors errors,Model model) {
		if(errors.hasErrors()) {
			return "home";
		}
		model.addAttribute("testVO", testVO);
		return "testProceed";
	}
}
