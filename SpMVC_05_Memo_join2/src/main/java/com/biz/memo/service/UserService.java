package com.biz.memo.service;

import com.biz.memo.domain.UserDTO;

public interface UserService {
/*
 * 회원가입처리: insert
 * 최초가입자를 과ㅣㄴ리자로 하자
 * 
 * id 중복검사
 * 
 * 로그인처리:= id 와 pass를 받아서 정상적인 정보인지 검사
 */
	public int userJoin(UserDTO userDTO);
	public boolean userIdCheck(String u_id);
	
	//DB에 있으면 true
	public boolean userLoginCheck(UserDTO userDTO);
	public UserDTO getUser(String u_id);
}
