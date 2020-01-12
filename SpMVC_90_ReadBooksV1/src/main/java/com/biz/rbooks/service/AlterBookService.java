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

	public int insertReadBook(BooksVO booksVO, HttpSession httpSession, ReadBookVO readBookVO) {
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		log.debug("!!! memberVO 값 in insertReadBook service:"+ memberVO.toString());
		MemberBCodesManagerVO memberBCodesManagerVO = new MemberBCodesManagerVO();
		
		/*SimpleDateFormat curDate = new SimpleDateFormat ( "yyyy-MM-dd");
		SimpleDateFormat curTime = new SimpleDateFormat ( "HH:mm:ss");
				
		Date time = new Date();
				
		String strcurDate = curDate.format(time);
		String strcurTime = curTime.format(time);
		*/
		String m_id=memberVO.getM_id();
		String startTime=readBookVO.getRb_stime();
		log.debug("!!! started time in insert service:"+startTime);
		readBookVO.setRb_bcode(booksVO.getB_code());
		readBookVO.setRb_rtime(timeCalculationService.calcTimeDiff(startTime));
		readBookVO.setRb_mid(m_id);
		
		memberBCodesManagerVO.setMng_b_code(booksVO.getB_code());
		memberBCodesManagerVO.setMng_member_id(memberVO.getM_id());
		try {
			log.debug("!!! inserting to memberBCodesManagerVO");
			memberBCodesManagerDao.insert(memberBCodesManagerVO);
		} catch (Exception e) {
			log.debug("이미 bcode가지고 있음");
		}
		
		return readBookDao.insert(readBookVO);
	}

	public ReadBookVO makeNewReadBookVO(String _b_code, HttpSession httpSession) {
		// TODO Auto-generated method stub
		BooksVO booksVO=booksDao.selectByBCode(_b_code);
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		ReadBookVO readBookVO=new ReadBookVO();
		readBookVO.setRb_bcode(booksVO.getB_code());
		readBookVO.setRb_bname(booksVO.getB_name());
		readBookVO.setRb_mid(memberVO.getM_id());
		return readBookVO;
	}
}
