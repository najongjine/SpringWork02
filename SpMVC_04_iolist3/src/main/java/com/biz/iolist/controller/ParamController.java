package com.biz.iolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/param" )
@Controller
public class ParamController {
	
	@RequestMapping(value = "/view",method=RequestMethod.GET)
	public String view() {
		
		return null;
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String update(String code) {
		log.debug("!!! update get called");
		log.debug(code);
		return "/param/update";
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(String code,String id, Model model) {
		log.debug("!!! update post called");
		log.debug(code);
		return "/param/update";
	}
}
