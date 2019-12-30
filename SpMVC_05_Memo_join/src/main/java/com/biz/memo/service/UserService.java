package com.biz.memo.service;

import java.util.List;

import com.biz.memo.domain.HobbyDTO;
import com.biz.memo.domain.UserDTO;

public interface UserService {
	//register
	public int userJoin(UserDTO userDTO);
	/*check id duplicate
	 * 만약 동일한 id가 테이블에 있으면 true return
	 */
	public boolean userIdCheck(String u_id);
	/*check login
	 * 1. userDTO를 매개변수로 받아서 DB에서 id와 pass를 검사
	 * 2. id와 pass가 모두일치하면 userDTO 객체를 return
	 * 3.그렇지 않으면 null return
	 */
	public UserDTO userLoginCheck(UserDTO userDTO);
	//update user
	public int userUpdate(UserDTO userDTO);
	//quit member. u_grade 정보만 변경
	public void userOut(UserDTO userDTO);
	//취미테이블 조회
	public List<HobbyDTO> getHobbyList();
}
