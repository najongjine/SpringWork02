package com.biz.memo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.memo.domain.UserDTO;

import lombok.extern.slf4j.Slf4j;

/*
 * Controller에서 객체(리스트)를 view로 보내는 방법
 * Model.addAttribute()
 * SessionAttribute() ModelAndAttribute()설정후 Model에 담기
 * 
 * HttpsSession.setAttribute()에 담기
 * 
 * Model: 일회용. controller -> view 보내기만을 위한 데이터
 *   modek에 담긴 데이터를 다시 server로ㅓ 보내려면 input tag에 갑을 담아서 다시 post로 전송
 *   
 * SessionAttribute+Model: 일회용데이터이면서 session 유지되는 데이터
 *   input view에서Spring form tag에 값을 담으면 이후에 자유롭게
 *   서버로 전송할수 있다.
 *   input, update 코딩을 간편하게 사용.
 *   spring에서 SessionAttribute일 경우 Garbage Collection이 적용됨.
 * HttpSession: 주로 login과 관련된 데이터를 유지하기위한 용도.
 *   시간설정을 하거나, 값을 remove 하거나, 서버가 멈출때까지 유지.
 *   모든 controller, 모든 view에서 값을 참조할수 있다.
 *   서버의 메모리공간을 많이 차지한다.
 *   GC적용 안됨.*/
@Slf4j
@RequestMapping(value = "/member")
@Controller
public class MemberController {
	@RequestMapping(value = "/join", method=RequestMethod.GET)
	public String join() {
		
		return null;
	}
	
	@RequestMapping(value = "/login",method=RequestMethod.GET)
	public String login(@RequestParam(value="LOGIN_MSG",required = false,defaultValue = "0")
	String msg,Model model) {
		log.debug("!!! LOGIN_MSG: "+msg);
		model.addAttribute("LOGIN_MSG", msg);
		return null;
	}

	@RequestMapping(value = "/login",method=RequestMethod.POST)
	public String login(UserDTO userDTO, Model model, HttpSession httpSession) {
		//DB에서 데이터 가져왔다 가정
		UserDTO getUserDTO=UserDTO.builder().u_id("najongjine").u_password("1234")
				.u_name("najongjine").u_tel("010-111-1111").build();
		//로그인 입력정보와 DB정보와 일치하는지 검사
		if(userDTO.getU_id().equalsIgnoreCase(getUserDTO.getU_id())
				&& userDTO.getU_password().equals(getUserDTO.getU_password())) {
			httpSession.setMaxInactiveInterval(10*60);
			httpSession.setAttribute("userDTO", getUserDTO);
		}else {
			httpSession.removeAttribute("userDTO");
		}
		return "redirect:/memo/list";
	}
	
	@RequestMapping(value = "/logout",method=RequestMethod.GET)
	public String logout(HttpSession httpSession) {
		httpSession.setAttribute("userDTO", null);
		httpSession.removeAttribute("userDTO");
		return "redirect:/memo/list";
	}
}
