package com.biz.rbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.repository.BooksDao;
import com.biz.rbooks.repository.MemberDao;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.extern.slf4j.Slf4j;

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
	
	public MemberVO makeTestData() {
		MemberVO memberVO=memberDao.findByM_ID("test1");
		List<BooksVO> booksList=booksDao.selectAll();
		memberVO.setBooksList(booksList);
		
		return memberVO;
	}
}
