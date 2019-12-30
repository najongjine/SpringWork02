package com.biz.pet.service;

import com.biz.pet.domain.UserDTO;

public interface UserService {

	/*
	 * 회원가입처리(insert)
	 * 회원가입처리를 할 때 최초 가입자는 관리자계정
	 * 아직 테이블에 어떤 회원정보도 등록되지 않은 상태에서 회원가입을 하면
	 * 해당 사용자의 u_grade 칼럼을 "A"로 설정,
	 * 그리고 그 이후 가입자는 일반 사용자로 "U"로 설
	 */
	public int userJoin(UserDTO userDTO); // id가 pk이므로 userDTO를 매개변수로 함
	
	/*
	 * id 중복검사
	 * 회원가입을 할 때 입력한 id가 기존 table에 중복되어있는지를 검사
	 * u_id를 매개변수로 받아서 table에서 회원 id를 검사한 후,
	 * 이미 해당 id가 테이블에 있으면 true return, 없으면 false return
	 */
	public boolean userIdCheck(String u_id);
	
	/*
	 * [로그인 처리]
	 * 회원 id와 password를 전달받아서 정상적인 정보인지를 검사,
	 * 
	 * 회원 id와 비밀번호를 매개변수로 받아서, 해당 정보와 일치하는 값이 있으면(회원가입이 되어있으면) true
	 * 없으면(회원 정보가 없거나, 비밀번호가 틀리면) false
	 * 
	 */
	public boolean userLoginCheck(UserDTO userDTO);
	
	public UserDTO getUser(String u_id);
	
	
}
