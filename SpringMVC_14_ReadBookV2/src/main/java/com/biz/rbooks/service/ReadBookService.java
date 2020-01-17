package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReadBookService {
	private final ReadBookDao rBookDao;

	public int insert(ReadBookVO rbookVO) {
		int ret=0;
		ret=rBookDao.insert(rbookVO);
		return ret;
	}

	public List<ReadBookVO> selectAll() {
		List<ReadBookVO> rBookList=rBookDao.selectAll();
		return rBookList;
	}

	public ReadBookVO findBySeq(long rb_seq) {
		// TODO Auto-generated method stub
		return rBookDao.findBySeq(rb_seq);
	}

	public int update(ReadBookVO rBookVO) {
		int ret=rBookDao.update(rBookVO);
		return 0;
	}

	public int delete(long rb_seq) {
		// TODO Auto-generated method stub
		return rBookDao.delete(rb_seq);
	}

	public List<ReadBookVO> findByBCode(String b_code) {
		// TODO Auto-generated method stub
		return rBookDao.findByBCode(b_code);
	}
}
