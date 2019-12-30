package com.biz.memo.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	@Autowired
	UserService uService;

	@RequestMapping(value = "/join",method=RequestMethod.GET)
	public String join(Model model) {
		/*
		 * insert.jsp 에서 spring form tag를 사용하면서 modelAttribute을 설정해 두었는데
		 * 해당 Atribute을 전닿해주지 않으면 form을 열때 오류가 발생한다.
		 * 때문에 초기화된 userDTO를 model에 실어서 보낸다.*/
		UserDTO userDTO=new UserDTO();
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("BODY", "JOIN");
		return "user/insert";
	}
	
	@RequestMapping(value = "/join",method=RequestMethod.POST)
	public String join(@Valid @ModelAttribute("userDTO") UserDTO userDTO, BindingResult bResult,
			Model model) {
		if(bResult.hasErrors()) {
			return "user/insert";
		} else {
			int ret=uService.userJoin(userDTO);
			return "redirect:/memo/list";
		}
	}
	
	@RequestMapping(value = "/mypage",method=RequestMethod.GET)
	public String mypage(Model model, HttpSession httpSession) {
		UserDTO userDTO=(UserDTO)httpSession.getAttribute("userDTO");
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("TITLE", "회원정보수정");
		return "user/insert";
	}
	
	@RequestMapping(value = "/idcheck",method=RequestMethod.GET)
	public String userIdCheck(Model model, String u_id) {
		boolean idYes=uService.userIdCheck(u_id);
		model.addAttribute("ID_YES", idYes);
		model.addAttribute("u_id", u_id);
		return "user/idcheck";
	}
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	//web browser로 문자열을 전송하라
	// method가 return하는 문자열을 resolverview에게 보내서 jsp파일과 렌더링 하는일을 하지 마라.
	//@responseBody가 없으면 통상 /views/.jsp 파일을 렌더링하여 브라우저로 전송
	@ResponseBody 
	@RequestMapping(value = "/pass",method=RequestMethod.GET)
	public String passwordTest(@RequestParam(value = "strText",
	required = false, defaultValue = "KOREA") String strText) {
	
		String cryptTest=passwordEncoder.encode(strText);
		long textLength=cryptTest.length();
		return cryptTest+" : "+textLength;
	}
}
