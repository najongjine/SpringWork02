package com.biz.rbooks.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.rbooks.domain.BookReadBookViewVO;
import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.MemberReadBookBooksViewVO;
import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.domain.util.PageDTO;
import com.biz.rbooks.repository.BooksDao;
import com.biz.rbooks.repository.MemberBCodesManagerDao;
import com.biz.rbooks.repository.MemberDao;
import com.biz.rbooks.repository.MemberReadBookBooksViewDao;
import com.biz.rbooks.repository.ReadBookDao;
import com.biz.rbooks.service.ReadBookService;
import com.biz.rbooks.service.util.PageService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/readbook")
public class ReadBookController {
	private final PageService pageService;
	private final MemberBCodesManagerDao memberBCodesManagerDao;
	private final MemberReadBookBooksViewDao memberReadBookBooksViewDao;
	private final ReadBookDao readBookDao;
	private final BooksDao booksDao;
	private final MemberDao memberDao;
	private final ReadBookService readBookService;
	
	@Autowired
	public ReadBookController(ReadBookDao readBookDao, BooksDao booksDao, MemberDao memberDao,
			ReadBookService readBookService,MemberReadBookBooksViewDao memberReadBookBooksViewDao
			,MemberBCodesManagerDao memberBCodesManagerDao,PageService pageService) {
		super();
		this.readBookDao = readBookDao;
		this.booksDao = booksDao;
		this.memberDao = memberDao;
		this.readBookService = readBookService;
		this.memberReadBookBooksViewDao=memberReadBookBooksViewDao;
		this.memberBCodesManagerDao=memberBCodesManagerDao;
		this.pageService=pageService;
	}
	
	/*
	 * HomeController 이후에 바로 연결된 simpleViewList req map 이다.
	 * 1. tbl_read_book 의 정보를 모두 가져올 것이다.
	 *  이 홈페이지의 목적은 책을 읽은 기록을 보는 것이고,
	 *  tbl_read_book 이라는 테이블이 그것을 저장하고 있기 때문이다.
	 * 2. 사용자가 검색을 하였을시, 검색조건에 맞춰서 정확한 데이터를 가져오도록 하였다.
	 * 3. 너무 많은 양의 정보를 한꺼번에 보여주지 않기위해, 
	 *  JAVA coding 기법의 페이지내이션을 하였다.
	 *  (oracle sql로 하는건 시도해봤는데 에러를 해결 못했다. 오라클은 쓰레기같다)
	 * 4. 검색한 후의 정보도 pagination을 유지하기위해 java code 기법을 쓴 필자는
	 *  httpSession을 이용하였다.
	 */
	@RequestMapping(value = "/simpleViewList",method = RequestMethod.GET)
	public String showAllList(@RequestParam(value="searchOption", required = false,
			defaultValue = "bnameSearch") String searchOption,
			@RequestParam(value="inputStr", required = false,
					defaultValue = "") String inputStr,Model model,@RequestParam(value = "currentPageNo", required = false,
			defaultValue = "1") int currentPageNo,HttpSession httpSession) {
		httpSession.setAttribute("searchOption", searchOption);
		httpSession.setAttribute("inputStr", inputStr);
		List<BookReadBookViewVO> bookReadBookViewList=null;
		
		if(searchOption.equalsIgnoreCase("bnameSearch")) {
			bookReadBookViewList=readBookDao.findAllBybNameBookReadBookView(inputStr);
		}
		else if (searchOption.equalsIgnoreCase("bcodeSearch")) {
			bookReadBookViewList=readBookDao.findAllByBCodeBookReadBookView(inputStr);
		}
		
		List<BookReadBookViewVO> pagedBookReadBookViewList=pageService.makeSimpleViewListPagination(bookReadBookViewList, currentPageNo);
		PageDTO pageDTO=pageService.getPage(currentPageNo);
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("bookReadBookViewList", pagedBookReadBookViewList);
		return "/simpleViewList";
	}
	
	/*
	 * 읽은 책의 기록을 상세보기 하였을때 작동되는 controller이다.
	 * tbl_member + tbl_books + tbl_read_book 테이블을 조인하였다.
	 * 
	 */
	@RequestMapping(value = "/viewdetail",method=RequestMethod.GET)
	public String viewDetail(@RequestParam("rb_seq")String strRb_seq, String _m_id,
			 Model model,HttpSession httpSession) {
		log.debug("!!! viewdail controller called");
		long rb_seq=-1;
		try {
			rb_seq=Long.valueOf(strRb_seq);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("!!! viewdetail controller 자료형 변환 오류");
		}
		
		MemberReadBookBooksViewVO memberReadBookBooksViewVO=memberReadBookBooksViewDao
				.findDetailByM_IdNRb_Seq(_m_id, rb_seq);
		model.addAttribute("memberReadBookBooksViewVO", memberReadBookBooksViewVO);
		return "/detailview";
	}
	
	/*
	 * 모든 책의 목록을 보여주는 cont.
	 * 2. 사용자가 검색을 하였을시, 검색조건에 맞춰서 정확한 데이터를 가져오도록 하였다.
	 * 3. 너무 많은 양의 정보를 한꺼번에 보여주지 않기위해, 
	 *  JAVA coding 기법의 페이지내이션을 하였다.
	 *  (oracle sql로 하는건 시도해봤는데 에러를 해결 못했다. 오라클은 쓰레기같다)
	 * 4. 검색한 후의 정보도 pagination을 유지하기위해 java code 기법을 쓴 필자는
	 *  httpSession을 이용하였다.
	 */
	@RequestMapping(value = "/viewAllBooks",method=RequestMethod.GET)
	public String viewAllBooks(@RequestParam(value="searchOption", required = false,
			defaultValue = "bnameSearch") String searchOption,
			@RequestParam(value="inputStr", required = false,
					defaultValue = "") String inputStr,Model model,@RequestParam(value = "currentPageNo", required = false,
			defaultValue = "1") int currentPageNo,HttpSession httpSession) {
		httpSession.setAttribute("searchOption", searchOption);
		httpSession.setAttribute("inputStr", inputStr);
		List<BooksVO> booksList=null;
		if(searchOption.equalsIgnoreCase("bnameSearch")) {
			booksList=booksDao.selectByBName(inputStr);
		}
		else if (searchOption.equalsIgnoreCase("bcodeSearch")) {
			booksList=(List<BooksVO>) booksDao.selectByBCode(inputStr);
		}
		
		List<BooksVO> pagedBooksList=pageService.makeViewAllBooksPagination(booksList, currentPageNo);
		PageDTO pageDTO=pageService.getPage(currentPageNo);
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("booksList", pagedBooksList);
		return "/viewallbooks";
	}
	
	/*
	 * 나만의 책 읽은 정보를 보여주는 cont.
	 * 2. 사용자가 검색을 하였을시, 검색조건에 맞춰서 정확한 데이터를 가져오도록 하였다.
	 * 3. 너무 많은 양의 정보를 한꺼번에 보여주지 않기위해, 
	 *  JAVA coding 기법의 페이지내이션을 하였다.
	 *  (oracle sql로 하는건 시도해봤는데 에러를 해결 못했다. 오라클은 쓰레기같다)
	 * 4. 검색한 후의 정보도 pagination을 유지하기위해 java code 기법을 쓴 필자는
	 *  httpSession을 이용하였다.
	 */
	@RequestMapping(value = "/myBookList",method=RequestMethod.GET)
	public String myBookList(@RequestParam(value="searchOption", required = false,
			defaultValue = "bnameSearch") String searchOption,
			@RequestParam(value="inputStr", required = false,
					defaultValue = "") String inputStr, Model model, HttpSession httpSession
			,@RequestParam(value = "currentPageNo", required = false,
			defaultValue = "1") int currentPageNo) {
		httpSession.setAttribute("searchOption", searchOption);
		httpSession.setAttribute("inputStr", inputStr);
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		//책 얼마 읽었냐 계산
		String m_id="";
		int totalBooksRead=0;
		try {
			m_id=memberVO.getM_id();
		} catch (Exception e) {
			log.debug("로그인 안됬음");
		}
		totalBooksRead=memberBCodesManagerDao.countMemberBCodesManager(m_id);
		
		List<MemberReadBookBooksViewVO> memberReadBookBooksViewList=null;
		if(searchOption.equalsIgnoreCase("bnameSearch")) {
			memberReadBookBooksViewList=memberReadBookBooksViewDao.
					findAllByM_IdNBName(memberVO.getM_id(), inputStr);
		}
		else if (searchOption.equalsIgnoreCase("bcodeSearch")) {
			memberReadBookBooksViewList=memberReadBookBooksViewDao.
					findAllByM_IdNBCode(memberVO.getM_id(), inputStr);
		}
		
		List<MemberReadBookBooksViewVO> pagedMemberReadBookBooksViewList=pageService.makeMyBookListPagination(memberReadBookBooksViewList, currentPageNo);
		PageDTO pageDTO=pageService.getPage(currentPageNo);
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("memberReadBookBooksViewList", pagedMemberReadBookBooksViewList);
		model.addAttribute("totalBooksRead", totalBooksRead);
		model.addAttribute("ISSEARCHED", "TRUE");
		return "/myBookList";
	}
	
	/*
	 * 정보보기(READ) 에서는 특별히 제약조건을 걸어두지 않았다.
	 */
	
}
