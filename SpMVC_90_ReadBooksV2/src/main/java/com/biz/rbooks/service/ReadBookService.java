package com.biz.rbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.BooksDao;
import com.biz.rbooks.repository.MemberDao;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.extern.slf4j.Slf4j;

/*
 * 여긴 개발 초기딴에서 Spring CRUD 패턴 지키려고 만든 서비스
 * 
 * 특별이 하는일이 없음.
 */
@Slf4j
@Service
public class ReadBookService {
	private final BooksDao booksDao;
	private final MemberDao memberDao;
	private final ReadBookDao readBookDao;
	
	@Autowired
	public ReadBookService(BooksDao booksDao, MemberDao memberDao, ReadBookDao readBookDao) {
		super();
		this.booksDao = booksDao;
		this.memberDao = memberDao;
		this.readBookDao = readBookDao;
	}
	
	public List<BooksVO> viewAllBooks() {
		return booksDao.selectAll();
	}
	
	public ReadBookVO findReadBookByRb_seq(long rb_seq) {
		return readBookDao.findByRB_SEQ(rb_seq);
	}
}
