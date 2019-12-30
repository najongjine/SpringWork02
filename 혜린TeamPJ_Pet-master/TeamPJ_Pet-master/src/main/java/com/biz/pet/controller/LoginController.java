package com.biz.pet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.pet.domain.UserDTO;
import com.biz.pet.service.UserService;
/*
 * Controller에서 객체(리스트)를 view로 보내는 방법
 * Model : 일회용 데이터, Controller >> view 보내기만을 위한 데이터(일방통행)
 * 		   Model에 담긴 데이터를 다시 서버로 보내려면 input tag에 값을 담아서 다시 POST로 전송해야함
 * 
 * SessionAttributes + Model : 일회용 데이터이면서 Session에 유지되는 데이터
 * 							   input view에서 Spring form tag에 값을 담으면 이후에 자유롭게 서버로 전송할 수 있다.
 * 							   input, update 코딩을 간편하게 사용하는 용도.
 * 							   Spring은 SessionAttribute를 사용하면 Garbage Collection이 적용된다.(사용안하면 Session 삭제)
 * 
 * HttpSession : 주로 login과 관련한 데이터를 *유지*하기위한 용도
 * 				 특별히 유지시간을 설정 하거나, 값을 remove하거나 server가 멈추기 전까지는 그 값을 유지하고 모든 controller, 모든 view에서 값 참조가 가능함.
 * 				 그러나, httpSession은 GarbageCollection에 적용되지 않기 때문에(표준 HTTP 프로토콜에 정의된 규격을 사용)
 * 				 httpSession은 server의 메모리 공간을 많이 차치재 server성능에 문제를 일으키키도 하므로 logi시에만 사용하는 것이 좋다.
 * 	
 */
@RequestMapping(value="/member")
@Controller
public class LoginController {

	@Autowired
	UserService uService;
	
	// 회원가입 폼으로 날려보낼 method
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join(Model model) {
		
		return null;
	}
	
	// 로그인 폼으로 날려보낼 method
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {

		return null;
	}
	
	// 실제 로그인을 수행할 method
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String BODY, @ModelAttribute UserDTO userDTO, Model model, HttpSession httpSession) {
	
		boolean loginOk = uService.userLoginCheck(userDTO);
		
		// 사용자가 있으면
		if(loginOk == true) {
			
			// session의 max유지값 10분
			httpSession.setMaxInactiveInterval(10*60);
			// DB로부터 사용자 정보 가져오기
			userDTO = uService.getUser(userDTO.getU_id());
			// 가져온 정보가 일치하면 사용자 정보 저장(모든 jsp에서 참조 가능)
			httpSession.setAttribute("userDTO", userDTO);
		
		// 사용자가 없으면
		}else {
			// session제거
			httpSession.removeAttribute("userDTO");
			// 로그인 실패 메시지를 사용자에게 보여주기
			model.addAttribute("LOGIN_MSG", "FAIL");
			// 다시 로그인시도할 수 있게 login폼으로 return
			return "redirect:/member/login";
		}
		// 로그인 성공하면 home화면으로 보내기
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		
		// session은 유지하되 내용만 Null로 함.
		httpSession.setAttribute("userDTO", null);
		
		return "redirect:/";
	}
}
