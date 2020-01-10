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

	public int insert(MemberVO newMemberVO, String re_password) {
		if(!newMemberVO.getM_password().equals(re_password))return -1;
		
		String encPass=passwordEncoder.encode(newMemberVO.getM_password());
		newMemberVO.setM_password(encPass);
		int nCount=memberDao.countMembers();
		if(nCount<1) {
			newMemberVO.setM_rem("ADMIN");
		}
		int ret=memberDao.insert(newMemberVO);
		return ret;
	}

	public MemberVO loginCheck(MemberVO inputtedMemberVO) {
		String inputted_id=inputtedMemberVO.getM_id();
		String inputted_password=inputtedMemberVO.getM_password();
		MemberVO existingMemberVO=memberDao.findByM_ID(inputted_id);
		if(existingMemberVO!=null) {
			String encPass=existingMemberVO.getM_password();
			if(passwordEncoder.matches(inputted_password, encPass)) {
				return existingMemberVO;
			}
		}
		return null;
	}

}
