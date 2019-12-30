package com.biz.pet.controller.info;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/info")
@Controller
public class InfoController {
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view() {
		return "info/view";
	}

}
