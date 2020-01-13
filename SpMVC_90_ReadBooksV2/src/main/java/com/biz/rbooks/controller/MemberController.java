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

	/*
	 * 로그인 시도시 불려지는 cont
	 * 
	 * 매게변수로 왜 memberVO를 붙인진 모르겠으나 작동은 잘 된다.
	 */
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(@ModelAttribute("memberVO") MemberVO memberVO) {
		return "login";
	}
	
	/*
	 * 로그인 페이지 폼에서 넘어온 데이터를 받는 cont
	 * 폼에 입력한 값들이 memberVO에 맵핑이 되게 
	 * memberVO를 매개변수로 넣어줬다.
	 * 
	 * memberService 에서 입력된 정보로 로그인이 되 있는지 체크한다.
	 * 
	 * 로그인 성공시 simpleviewlist 페이지로 이동한다.
	 */
	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(@ModelAttribute("memberVO") MemberVO memberVO, HttpSession httpSession, Model model) {
		memberVO=memberService.loginCheck(memberVO);
		if(memberVO!=null) {
			httpSession.setAttribute("memberVO", memberVO);
		} else {
			//로그인 실패시 안전을 위해 memberVO를 제거를 해주고 다시 로그인 페이지로 이동시킨다.
			httpSession.removeAttribute("memberVO");
			return "redirect:/member/login";
		}
		//로그인 성공시
		return "redirect:/readbook/simpleViewList";
	}
	
	/*
	 * 회원가입 폼을 보여주는 페이지
	 */
	@RequestMapping(value = "/register",method=RequestMethod.GET)
	public String register() {
		return "/register";
	}
	
	/*
	 * 입력된 회원정보를 DB에 추가시켜주는 cont
	 * memberService를 통해서 insert method를 통해서 sql을 통해서 DB에 저장
	 * 
	 * 회원가입이 끝나면 메인화면으로 이동
	 */
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public String register(@ModelAttribute("memberVO") MemberVO memberVO, String re_password) {
		int ret=memberService.insert(memberVO,re_password);
		if(ret<1) {
			log.debug("!!!화원가입 안됨!!!");
		}
		return "redirect:/readbook/simpleViewList";
	}
	
	/*
	 * 로그아웃시 httpSession에서 memberVO 값을 제거해 버린다.
	 * 
	 * 그후 메인페이지로 이동
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession httpSession) {
		httpSession.removeAttribute("memberVO");
		return "redirect:/readbook/simpleViewList";
	}
}
