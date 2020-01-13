package com.biz.rbooks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.BooksDao;
import com.biz.rbooks.repository.ReadBookDao;

import lombok.extern.slf4j.Slf4j;

/*
 * rest 컨트롤러이다.
 * 이 컨트롤러는 보안이 중요한 기능들중에 상요자에겐 결과를 보여줄 필요가 없는
 * 기능들을 수행하기위해 만들어졌다.
 * 
 * 예를 들면 삭제 기능이다.
 * 
 * 삭제를 get방식으로 하면 ADMIN 계정관련 체크를 통해서 막을수도 있겠지만,
 * get방식으로 삭제를 하면 서버의 작동방식을 그대로 보여주기 때문에
 * 나보다 실력이 좋은 사람에게 내 서버 작동 방식이 보여지면 내 홈페이지는 파괴당할 확률이 100%다.
 */
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

/*
 * 웹페이지 주소창에 상세정보를 숨기기 위해 POST 방식으로 접근하게 하였다.
 * 
 * alterReadBook 페이지에서 삭제버튼을 누를시, 버튼에 스크립트를 걸었다.
 * 스크립트에서는 post방식으로 _rb_seq 값을 보내준다.
 * 
 * 또한 스크립트에서 나의 아이디와 게시물이 작성된 아이디가 틀리면
 * 아예 수정,삭제 진입이 안되게 하였다
 * 
 */
	@RequestMapping(value = "/deleteReadBook",method=RequestMethod.POST)
	public String deleteReadBook(String _rb_seq,Model model) {
		long rb_seq=-1;
		try {
			rb_seq=Long.valueOf(_rb_seq);
		} catch (Exception e) {
			log.debug("!!! updateReadBook post controller 자료형 변환중 에러");
		}
		
		//rb_seq를 이용해 삭제하고자 하는 튜플을 찾음
		ReadBookVO readBookVO=readBookDao.findByRB_SEQ(rb_seq);
		
		//특별한 추가작업이 필요 없어서 바로 dao를 불러서 삭제
		int ret=readBookDao.delete(rb_seq);
		return "OK";
	}
	
	/*
	 * 책을 삭제하는 cont
	 * 스크립트로 넘어온 _rb_bcode를 이용하여 특정한 책을 삭제.
	 */
	@RequestMapping(value = "/deleteBook",method=RequestMethod.POST)
	public String deleteBook(String _rb_bcode,HttpSession httpSession) {
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");

		// ADMIN계정이 아니면 책을 삭제할수 없도록 함.
		if(!memberVO.getM_rem().equalsIgnoreCase("ADMIN")) {
			return null;
		}
		//특별한 추가 작업이 필요 없어서 바로 dao를 통해서 삭제
		int ret=booksDao.delete(_rb_bcode);
		return "OK";
	}
}
