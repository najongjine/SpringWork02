package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.jta.UserTransactionAdapter;

import com.biz.memo.domain.UserDTO;
import com.biz.memo.persistence.UserDao;

/*
 * interface를 imp하여 생성한 클래스에 @service를 붙여주면
 * autowired를 수행할때 interface 객체 형식으로 코드를 작성하면
 * 자동으로 해당 객체를 가져와서 객체를 초기화 하여준다.
 */

@Service
public class UserServiceImp  implements UserService {
	@Autowired
	SqlSession sqlSession;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	UserDao uDao;
	
	@Autowired
	public void makeUserDao() {
		uDao=sqlSession.getMapper(UserDao.class);
	}
	
	@Override
	public int userJoin(UserDTO userDTO) {
		// TODO Auto-generated method stub
		if(uDao.userCount()>0) {
			userDTO.setU_grade("U");
		} else {
			userDTO.setU_grade("A");
		}
		String cryptText=passwordEncoder.encode(userDTO.getU_password());
		userDTO.setU_password(cryptText);
		return uDao.userInsert(userDTO);
	}

	@Override
	public boolean userIdCheck(String u_id) {
		UserDTO userDTO=uDao.findById(u_id);
		if(userDTO!=null && userDTO.getU_id().equalsIgnoreCase(u_id)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean userLoginCheck(UserDTO userDTO) {
		// TODO Auto-generated method stub
		String inU_id=userDTO.getU_id();
		String inU_pass=userDTO.getU_password();
		//암호화를 대비한 코드로 작성
		UserDTO userRDTO=uDao.findById(inU_id);
		if(userRDTO==null) {
			return false;
		}
		String sU_id=userRDTO.getU_id();
		String sU_pass=userRDTO.getU_password();
		String cryptU_pass=userRDTO.getU_password();
		if(sU_id.equalsIgnoreCase(inU_id)&&passwordEncoder.matches(inU_pass, cryptU_pass)) {
			
			/*
			 * java method에서 객체를 매개변수로 받은후 
			 * 각 필드 변수들을 개별적으로 변경을 하면 
			 * 파라메터로 주입한 원본에 변수값들이 변경이 된다.
			 * 
			 * 하지만 객체=다른객체 
			 * 또는 객체=new Class() 형식으로 자체를 변경해 버리면
			 * 파라메터로 주입한 원본은 변경이 되지 않음.
			 */
			//userDTO=userRDTO;
			userDTO.setU_grade(userRDTO.getU_grade()); //...
			return true;
		} else {
			return false;
		}
	}

	@Override
	public UserDTO getUser(String u_id) {
		// TODO Auto-generated method stub
		return uDao.findById(u_id);
	}

}
