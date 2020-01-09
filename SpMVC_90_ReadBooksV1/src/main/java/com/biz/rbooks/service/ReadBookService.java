package com.biz.rbooks.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.javassist.compiler.MemberCodeGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.DetailBookViewVO;
import com.biz.rbooks.domain.MemberBCodesManagerVO;
import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.domain.SimpleViewVO;
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
	
	public List<SimpleViewVO> showAllSummary() {
		List<SimpleViewVO> simpleViewList=new ArrayList<SimpleViewVO>();
		List<MemberVO> memberList=memberDao.selectAll();
		String m_id="";
		String b_code="";
		String b_name="";
		String rb_date="";
		String rb_subject="";
		int tb_star=0;
		
		for(MemberVO memberVO: memberList) {
			m_id=memberVO.getM_id();
			for(MemberBCodesManagerVO memberBCodesManagerVO:memberVO.getMemberBCodesManagerList()) {
				b_code=memberBCodesManagerVO.getMng_b_code();
				b_name=memberBCodesManagerVO.getBooksVO().getB_name();
				int readBookListSize=memberBCodesManagerVO.getBooksVO().getReadBookList().size();
				rb_date=memberBCodesManagerVO.getBooksVO().getReadBookList().get(0).getRb_date();
				rb_subject=memberBCodesManagerVO.getBooksVO().getReadBookList()
						.get(readBookListSize-1).getRb_subject();
				tb_star=memberBCodesManagerVO.getBooksVO().getReadBookList()
						.get(readBookListSize-1).getRb_star();
				SimpleViewVO simpleViewVO=SimpleViewVO.builder().b_code(b_code).b_name(b_name)
						.m_id(m_id).rb_date(rb_date).rb_subject(rb_subject).tb_star(tb_star).build();
				simpleViewList.add(simpleViewVO);
			}
		}
		return simpleViewList;
	}
	
	public MemberVO makeTestData() {
		MemberVO memberVO=memberDao.findByM_ID("test1");
		List<BooksVO> booksList=booksDao.selectAll();
		
		return memberVO;
	}

	public DetailBookViewVO viewDetailOfBook(long rb_seq, String b_code, String m_id) {
		// TODO Auto-generated method stub
		MemberVO memberVO=memberDao.findByM_ID(m_id);
		BooksVO booksVO=booksDao.selectByBCode(b_code);
		DetailBookViewVO detailBookViewVO=new DetailBookViewVO();
		detailBookViewVO.setM_id(m_id);
		detailBookViewVO.setB_auther(booksVO.getB_auther());
		detailBookViewVO.setB_code(booksVO.getB_code());
		detailBookViewVO.setB_comp(booksVO.getB_comp());
		detailBookViewVO.setB_iprice(booksVO.getB_iprice());
		detailBookViewVO.setB_name(booksVO.getB_name());
		detailBookViewVO.setB_year(booksVO.getB_year());
		detailBookViewVO.setReadBookList(booksVO.getReadBookList());
		
		return detailBookViewVO;
	}
}
