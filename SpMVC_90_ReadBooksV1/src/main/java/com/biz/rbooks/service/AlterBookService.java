package com.biz.rbooks.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.MemberBCodesManagerVO;
import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.BooksDao;
import com.biz.rbooks.repository.MemberBCodesManagerDao;
import com.biz.rbooks.repository.MemberDao;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlterBookService {
	private final BooksDao booksDao;
	private final 	MemberBCodesManagerDao memberBCodesManagerDao;
	private final MemberDao memberDao;
	private final ReadBookDao readBookDao;
	
	@Autowired
	public AlterBookService(BooksDao booksDao, MemberBCodesManagerDao memberBCodesManagerDao, MemberDao memberDao,
			ReadBookDao readBookDao) {
		super();
		this.booksDao = booksDao;
		this.memberBCodesManagerDao = memberBCodesManagerDao;
		this.memberDao = memberDao;
		this.readBookDao = readBookDao;
	}

	public int updateReadBook(ReadBookVO readBookVO) {
		int ret=readBookDao.update(readBookVO);
		return ret;
	}

	public int insertReadBook(BooksVO booksVO, HttpSession httpSession) {
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		log.debug("!!! memberVO 값 in insertReadBook service:"+ memberVO.toString());
		MemberBCodesManagerVO memberBCodesManagerVO = new MemberBCodesManagerVO();
		
		SimpleDateFormat curDate = new SimpleDateFormat ( "yyyy-MM-dd");
		SimpleDateFormat curTime = new SimpleDateFormat ( "HH:mm:ss");
				
		Date time = new Date();
				
		String strcurDate = curDate.format(time);
		String strcurTime = curTime.format(time);
		
		ReadBookVO readBookVO=new ReadBookVO();
		readBookVO.setRb_bcode(booksVO.getB_code());
		readBookVO.setRb_date(strcurDate);
		readBookVO.setRb_rtime(0);
		readBookVO.setRb_star(0);
		readBookVO.setRb_stime(strcurTime);
		readBookVO.setRb_subject("");
		readBookVO.setRb_text("");
		
		memberBCodesManagerVO.setMng_b_code(booksVO.getB_code());
		memberBCodesManagerVO.setMng_member_id(memberVO.getM_id());
		memberBCodesManagerDao.insert(memberBCodesManagerVO);
		return readBookDao.insert(readBookVO);
	}
}
