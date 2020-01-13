package com.biz.rbooks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.repository.MemberDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberService {
	private final BCryptPasswordEncoder passwordEncoder;
	private final MemberDao memberDao;
	
	@Autowired
	public MemberService(BCryptPasswordEncoder passwordEncoder, MemberDao memberDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.memberDao = memberDao;
	}

	/*
	 * 
	 */
	public int insert(MemberVO newMemberVO, String re_password) {
		//비밀번호 재 입력이 틀릴시 회원가입 안되게 빠져나옴
		if(!newMemberVO.getM_password().equals(re_password))return -1;
		
		//입력한 비번을 암호화
		String encPass=passwordEncoder.encode(newMemberVO.getM_password());
		
		//암호화 된 비번을 VO에 셋팅
		newMemberVO.setM_password(encPass);
		
		//첫번째 가입자를 자동 ADMIN으로 설정
		int nCount=memberDao.countMembers();
		if(nCount<1) {
			newMemberVO.setM_rem("ADMIN");
		}
		
		//memberVO에 설정된 값을 이용해서 Dao를 통해서
		//SQL을 통해서 DB에 추가
		int ret=memberDao.insert(newMemberVO);
		return ret;
	}

	/*
	 * 입력한 id와 pass로 DB에 그 유저가 있는지 검색한다.
	 */
	public MemberVO loginCheck(MemberVO inputtedMemberVO) {
		String inputted_id=inputtedMemberVO.getM_id();
		String inputted_password=inputtedMemberVO.getM_password();
		
		//먼저 아이디로 검색하고
		MemberVO existingMemberVO=memberDao.findByM_ID(inputted_id);
		if(existingMemberVO!=null) {
			String encPass=existingMemberVO.getM_password();
			
			//입력한 패스와 암호화되어 저장된 패스를 matches 함수를 이용해서
			//비번을 잘 입력 했는지 검사한다.
			if(passwordEncoder.matches(inputted_password, encPass)) {
				return existingMemberVO;
			}
		}
		return null;
	}

}
