package com.biz.gallery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.gallery.domain.MemberVO;
import com.biz.gallery.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping(value = "/member")
@Controller
@Slf4j
public class MemberController {
	protected final MemberService mService;

	@Autowired
	public MemberController(MemberService mService) {
		super();
		this.mService = mService;
	}

	@RequestMapping(value = "/join",method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("MODAL", "JOIN");
		return "home";
	}
	
	@RequestMapping(value = "/join",method=RequestMethod.POST)
	public String join(MemberVO memberVO,Model model) {
		mService.insert(memberVO);
		return "redirect:/image/list";
	}
	
	//@ResponseBody
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(MemberVO memberVO, Model model, HttpSession httpSession) {
		memberVO=mService.loginCheck(memberVO);
		if(memberVO!=null) {
			httpSession.setAttribute("MEMBER", memberVO);
			//return "LOGIN_OK";
		} else {
			httpSession.removeAttribute("MEMBER");
			//return "LOGIN_FAIL";
		}
		return "redirect:/image/list";
	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("MEMBER");
		return "redirect:/image/list";
	}
}
