package com.biz.rbooks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.repository.MemberDao;
import com.biz.rbooks.service.MemberService;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/member")
public class MemberController {
	public final MemberDao memberDao;
	public final MemberService memberService;
	
	@Autowired
	public MemberController(MemberDao memberDao, MemberService memberService) {
		super();
		this.memberDao = memberDao;
		this.memberService = memberService;
	}

	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("memberVO") MemberVO memberVO) {
		return "login";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("memberVO") MemberVO memberVO, HttpSession httpSession, Model model) {
		log.debug("!!!login post called");
		memberVO=memberService.loginCheck(memberVO);
		log.debug("!!! membervo 값:"+memberVO.toString());
		if(memberVO!=null) {
			httpSession.setAttribute("memberVO", memberVO);
		} else {
			httpSession.removeAttribute("memberVO");
		}
		return "redirect:/readbook/showalllist";
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("memberVO") MemberVO memberVO, String re_password) {
		int ret=memberService.insert(memberVO,re_password);
		if(ret<1) {
			log.debug("!!!화원가입 안됨!!!");
		}
		return "redirect:/readbook/showalllist";
	}
}
