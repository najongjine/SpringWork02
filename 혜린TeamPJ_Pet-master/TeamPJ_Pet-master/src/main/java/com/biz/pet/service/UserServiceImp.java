package com.biz.pet.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.UserDTO;
import com.biz.pet.persistence.UserDao;

// interface 객체형식으로 코드를 작성하면 자동으로 해당 객체를 가져와서 초기화해줌.
// interface로 선언하고 service로 초기화를 시켜준다.
// service Annotation은 실제 Service클래스에 붙여준다(interface에는 붙이지말기)
@Service
public class UserServiceImp implements UserService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder; // rootContext bean의 id와 같게 설정해
	
	UserDao uDao;
	
	@Autowired
	public void getUserDao() {
		uDao = sqlSession.getMapper(UserDao.class);
	}
	
	@Override
	public int userJoin(UserDTO userDTO) {

		String cryptText = passwordEncoder.encode(userDTO.getU_password());
		userDTO.setU_password(cryptText);
		return uDao.userInsert(userDTO);
	}

	@Override
	public boolean userIdCheck(String u_id) {
		
		UserDTO userDTO = uDao.findById(u_id);
		
		if(userDTO != null && userDTO.getU_id().equalsIgnoreCase(u_id)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userLoginCheck(UserDTO userDTO) {

		// inU_id = 입력받은 u_id
		String inU_id = userDTO.getU_id();
		String inU_pass = userDTO.getU_password();
		
		UserDTO userRDTO = uDao.findById(inU_id);
		
		if(userRDTO == null) {
			return false;
		}
		// sU_id = select로 조회한 id
		String sU_id = userRDTO.getU_id();
		String sU_pass = userRDTO.getU_password();
		
		// table에 저장되어있는 암호화된 password
		String cryptU_pass = userRDTO.getU_password();
		
		// .matches method는 암호회된 문자열 = 입력받은 문자열인지 검사해줌
		// &&을 이용하여 회원아이디는 존재하지만 password는 틀렸을 경우도 false값을 return하게 해줌
		if(sU_id.equalsIgnoreCase(inU_id) && passwordEncoder.matches(inU_pass, cryptU_pass)) {
			// id와 비밀번호가 모두 일치하는 경우에만 true return
			return true;
		}else {
			return false;
		}
	}

	@Override
	public UserDTO getUser(String u_id) {
		return uDao.findById(u_id);
	}

}
