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
import com.biz.rbooks.service.util.TimeCalculationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AlterBookService {
	TimeCalculationService timeCalculationService=new TimeCalculationService();
	private final BooksDao booksDao;
	private final MemberBCodesManagerDao memberBCodesManagerDao;
	private final MemberDao memberDao;
	private final ReadBookDao readBookDao;
	
	@Autowired
	public AlterBookService(BooksDao booksDao, MemberBCodesManagerDao memberBCodesManagerDao, MemberDao memberDao,
			ReadBookDao readBookDao,TimeCalculationService timeCalculationServic) {
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

	/*
	 * 책 다 읽음을 눌렀을시 작동하는 method
	 * 
	 *  책 얼마동안 읽었는지 계산해서 
	 *  여러가지 정보 다 셋팅후 tbl_read_book에 insert
	 */
	public int insertReadBook(BooksVO booksVO, HttpSession httpSession, ReadBookVO readBookVO) {
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		MemberBCodesManagerVO memberBCodesManagerVO = new MemberBCodesManagerVO();
		
		String m_id=memberVO.getM_id();
		String startTime=readBookVO.getRb_stime();
		readBookVO.setRb_bcode(booksVO.getB_code());
		readBookVO.setRb_rtime(timeCalculationService.calcTimeDiff(startTime));
		readBookVO.setRb_mid(m_id);
		
		memberBCodesManagerVO.setMng_b_code(booksVO.getB_code());
		memberBCodesManagerVO.setMng_member_id(memberVO.getM_id());
		try {
			//member_bcode_manager 는 다중유저 지원을 위해 내가 추가로 만든 table
			//b_code를 PK 쓰기 때문에 제약조건 오류 처리를 위한 try문
			memberBCodesManagerDao.insert(memberBCodesManagerVO);
		} catch (Exception e) {
			log.debug("이미 bcode가지고 있음");
		}
		
		return readBookDao.insert(readBookVO);
	}

	/*
	 * viewAllBooks 페이지에서 책 읽기 버튼을 눌렀을시 발동되는 service
	 * 현재 날짜와 시간을 계산한다.
	 */
	public ReadBookVO makeNewReadBookVO(String _b_code, HttpSession httpSession) {
		// 어떤 책을 읽는지 알아내기 위해서 _b_code 를 이용해 DB에서 검색
		BooksVO booksVO=booksDao.selectByBCode(_b_code);
		
		//m_id 도 알아내고
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		
		//책 새로 추가하기위해 VO새로 만들고
		ReadBookVO readBookVO=new ReadBookVO();
		
		//책 정보, 누가 읽었는지 셋팅해주고
		readBookVO.setRb_bcode(booksVO.getB_code());
		readBookVO.setRb_bname(booksVO.getB_name());
		readBookVO.setRb_mid(memberVO.getM_id());
		
		//셋팅된 VO를 호출한 method에 넘겨준
		return readBookVO;
	}
}
