package com.biz.friend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biz.friend.domain.MemberVO;
import com.biz.friend.repository.MemberDao;
import com.biz.friend.service.util.EncService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {
	private final BCryptPasswordEncoder passwordEncoder;
	private final EncService encService;
	private final MemberDao memberDao;
	
	public int insert(MemberVO memberVO) {
		memberVO.setM_password(encService.encString(memberVO.getM_password()));
		return memberDao.insert(memberVO);
	}
	
	public MemberVO findByUsername(String m_username) {
		return memberDao.findByUsername(m_username);
	}
	
	public MemberVO loginCheck(MemberVO memberVO) {
		String rawPass=memberVO.getM_password();
		memberVO=findByUsername(memberVO.getM_username());
		if(memberVO==null) {
			log.debug("!!! cannot find uername");
			return null;
		}
		
		String decPass=encService.decString(memberVO.getM_password());
		if(!decPass.equals(rawPass)) {
			log.debug("password is wrong");
			return null;
		}
		return memberVO;
	}
}
