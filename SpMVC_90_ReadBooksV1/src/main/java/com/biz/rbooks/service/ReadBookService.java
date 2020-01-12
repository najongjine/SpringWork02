package com.biz.rbooks.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.ibatis.javassist.compiler.MemberCodeGen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.DetailBookViewVO;
import com.biz.rbooks.domain.MemberBCodesManagerVO;
import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.domain.ReadBookVO;
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
		log.debug("!!! memberlist:"+memberList.toString());
		String m_id="";
		String b_code="";
		String b_name="";
		String rb_date="";
		String rb_subject="";
		int tb_star=0;
		long rb_seq=-1;
		
		for(MemberVO memberVO: memberList) {
			//m_id=memberVO.getM_id();
			log.debug("!!! ? getMemberBCodesManagerList:"+ memberVO.getMemberBCodesManagerList().toString());
			
			for(MemberBCodesManagerVO memberBCodesManagerVO:memberVO.getMemberBCodesManagerList()) {
				memberBCodesManagerVO.setBooksVO(booksDao.selectByBCode(memberBCodesManagerVO.getMng_b_code()));
				log.debug("!!! bookvo:"+memberBCodesManagerVO.getBooksVO().toString());
				log.debug("!!! ? getReadBookList:"+ memberBCodesManagerVO.getBooksVO().getReadBookList().toString());
				Collections.sort(memberBCodesManagerVO.getBooksVO().getReadBookList(), new Comparator<ReadBookVO>() {

					@Override
					public int compare(ReadBookVO o1, ReadBookVO o2) {
						return (int) (o2.getRb_seq()-o2.getRb_seq());
					}
				});
				m_id=
				b_code=memberBCodesManagerVO.getMng_b_code();
				b_name=memberBCodesManagerVO.getBooksVO().getB_name();
				int readBookListSize=memberBCodesManagerVO.getBooksVO().getReadBookList().size();
				rb_date=memberBCodesManagerVO.getBooksVO().getReadBookList().get(0).getRb_date();
				rb_subject=memberBCodesManagerVO.getBooksVO().getReadBookList()
						.get(0).getRb_subject();
				tb_star=memberBCodesManagerVO.getBooksVO().getReadBookList()
						.get(0).getRb_star();
				rb_seq=memberBCodesManagerVO.getBooksVO().getReadBookList()
						.get(0).getRb_seq();
				SimpleViewVO simpleViewVO=new SimpleViewVO();
				simpleViewVO.setB_code(b_code);
				simpleViewVO.setB_name(b_name);
				simpleViewVO.setM_id(m_id);
				simpleViewVO.setRb_date(rb_date);
				simpleViewVO.setRb_seq(rb_seq);
				simpleViewVO.setRb_subject(rb_subject);
				simpleViewVO.setTb_star(tb_star);
				
				log.debug("!!! simpleViewVO:"+simpleViewVO.toString() );
				simpleViewList.add(simpleViewVO);
			}
		}
		log.debug("!!! simpleViewList:"+simpleViewList.toString());
		return simpleViewList;
	}

	public DetailBookViewVO viewDetailOfBook(long rb_seq, String b_code, String _m_id) {
		// TODO Auto-generated method stub
		MemberVO memberVO=memberDao.findByM_ID(_m_id);
		BooksVO booksVO=booksDao.selectByBCode(b_code);
		DetailBookViewVO detailBookViewVO=new DetailBookViewVO();
		detailBookViewVO.setM_id(_m_id);
		detailBookViewVO.setB_auther(booksVO.getB_auther());
		detailBookViewVO.setB_code(booksVO.getB_code());
		detailBookViewVO.setB_comp(booksVO.getB_comp());
		detailBookViewVO.setB_iprice(booksVO.getB_iprice());
		detailBookViewVO.setB_name(booksVO.getB_name());
		detailBookViewVO.setB_year(booksVO.getB_year());
		detailBookViewVO.setReadBookList(booksVO.getReadBookList());
		
		return detailBookViewVO;
	}

	public List<BooksVO> viewAllBooks() {
		return booksDao.selectAll();
	}
	
	public ReadBookVO findReadBookByRb_seq(long rb_seq) {
		return readBookDao.findByRB_SEQ(rb_seq);
	}
}
