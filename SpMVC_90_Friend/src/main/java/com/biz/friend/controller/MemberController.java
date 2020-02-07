package com.biz.friend.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.friend.domain.MemberVO;
import com.biz.friend.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {
	private final MemberService memberService;
	
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("mode", "register");
		return "member/input";
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String register(MemberVO memberVO,Model model) {
		memberService.insert(memberVO);
		model.addAttribute("mode", "login");
		return "member/input";
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("mode", "login");
		return "/member/input";
	}
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(MemberVO memberVO,HttpSession httpSession,Model model) {
		memberVO=memberService.loginCheck(memberVO);
		if(memberVO==null) {
			return "/member/loginFail";
		}
		httpSession.setAttribute("memberVO", memberVO);
		
		return "redirect:/friend/showAll";
	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("memberVO");
		return "redirect:/friend/showAll";
	}
}
