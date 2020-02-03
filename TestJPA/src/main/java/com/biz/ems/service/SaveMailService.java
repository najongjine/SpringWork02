package com.biz.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biz.ems.domain.EmailVO;
import com.biz.ems.repository.EmailDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SaveMailService {
	private final EmailDao emsDao;
	
	public int delete(long ems_seq) {
		emsDao.deleteById(ems_seq);
		return 0;
	}
	
	public int insert(EmailVO emailVO) {
		int ret=0;
		emsDao.save(emailVO);
		return ret;
	}
	
	public List<EmailVO> selectAll(){
		List<EmailVO> mailList=(List<EmailVO>) emsDao.findAll();
		return mailList;
	}
	
	public EmailVO findBySeq(long ems_seq) {
		Optional<EmailVO> emailVO=emsDao.findById(ems_seq);
		//EmailVO emailVO=emsDao.findByEmsSeq(ems_seq);
		//return emailVO;
		return (EmailVO) emailVO.get();
	}

	public int update(EmailVO emailVO) {
		emsDao.save(emailVO);
		return 0;
	}
}
