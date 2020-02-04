package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.domain.BBsVO;

import lombok.extern.slf4j.Slf4j;

@Service
public interface BBsService {
	public List<BBsVO> selectAll();
	public BBsVO findById(long bbs_id);
	
	//제목으로 검색하기
	public List<BBsVO> findBySubject(String subject);
	
	//작성자로 검색하기
	public List<BBsVO> findByWriter(String writer);
	
	// 제목과 작성자로 검색하기
	public List<BBsVO> findBySubAndWriter(String subject, String writer);
	
	// insert || update
	public int save(BBsVO bbsVO);
	
	public int delete(long bbs_id);
	public BBsVO reply(BBsVO bbsVO);
}
