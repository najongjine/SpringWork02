package com.biz.rbooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.BooksDao;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/rest")
public class RestReadBookController {
	private final BooksDao booksDao;
	private final ReadBookDao readBookDao;
	
	@Autowired
	public RestReadBookController(ReadBookDao readBookDao,BooksDao booksDao) {
		super();
		this.readBookDao = readBookDao;
		this.booksDao=booksDao;
	}


	@RequestMapping(value = "/deleteReadBook",method=RequestMethod.POST)
	public String deleteReadBook(String _rb_seq,Model model) {
		log.debug("!!! deleteReadBook called" );
		long rb_seq=-1;
		try {
			rb_seq=Long.valueOf(_rb_seq);
		} catch (Exception e) {
			log.debug("!!! updateReadBook post controller 자료형 변환중 에러");
		}
		ReadBookVO readBookVO=readBookDao.findByRB_SEQ(rb_seq);
		String b_code=readBookVO.getRb_bcode();
		
		int ret=readBookDao.delete(rb_seq);
		log.debug("!!!ret:"+ret);
		model.addAttribute("rb_seq", rb_seq);
		model.addAttribute("b_code", b_code);
		model.addAttribute("m_id", "test1");
		model.addAttribute("OK", "OK");
		return "OK";
	}
	
	@RequestMapping(value = "/deleteBook",method=RequestMethod.POST)
	public String deleteBook(String _rb_bcode) {
		int ret=booksDao.delete(_rb_bcode);
		return "OK";
	}
}
