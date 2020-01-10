package com.biz.rbooks.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter{
	/*
	 * dispatcher에서 controller로 가는 도중 가로채기를 수행할 method
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String urlPath=request.getRequestURL().toString();
		String uriPath=request.getRequestURI().toString();
		String msg=String.format("\n URL:%s, \n URI: %s", urlPath,uriPath);
		
		//login 정보 확인
		//1. res로부터 sessikon id 추출
		HttpSession httpSession=request.getSession();
		
		//member 세션을 확인하기 위해서 attribute를 추출해서 object 객체(sessionobj) 에 담기
		Object sessionObj=httpSession.getAttribute("memberVO");
		
		//object 객체가 null 확인. null이면 member session 객체가 없다==not logged in
		if(sessionObj==null) {
			// 로그인 화면(form)으로 redirect를 수행하여 login을 하도록 유도
			response.sendRedirect(request.getContextPath()+"/member/login");
			//현재 로그인이 안되어 있으므로 dispatcher에게 더이상 다른일을 수행하지 말라
			return false;
		}
		
		log.debug("나는 인터셉터");
		log.debug(msg);
		return super.preHandle(request, response, handler); // ==return true;
	}
}
