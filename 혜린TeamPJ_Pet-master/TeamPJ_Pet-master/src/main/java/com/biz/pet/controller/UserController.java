package com.biz.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.pet.domain.UserDTO;
import com.biz.pet.service.UserService;

@RequestMapping(value="/member")
@Controller
public class UserController {

	@Autowired
	UserService uService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		UserDTO userDTO = new UserDTO();
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("BODY", "JOIN");
		
		return "user/insert";
	}
	
	
}
