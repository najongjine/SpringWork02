package com.biz.rbooks.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.MemberVO;
import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.repository.BooksDao;
import com.biz.rbooks.repository.MemberBCodesManagerDao;
import com.biz.rbooks.repository.MemberDao;
import com.biz.rbooks.repository.ReadBookDao;
import com.biz.rbooks.service.AlterBookService;
import com.biz.rbooks.service.ReadBookService;
import com.biz.rbooks.service.util.TimeCalculationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("{readBookVO},{booksVO}")
@RequestMapping(value = "/alter")
public class AlterBookController {
	private final ReadBookService readBookService;
	private final AlterBookService alterBookService;
	private final TimeCalculationService timeCalculationService;
	
	private final ReadBookDao readBookDao;
	private final BooksDao booksDao;
	private final MemberDao memberDao;
	private final MemberBCodesManagerDao memberBCodesManagerDao;
	
	@Autowired
	public AlterBookController(ReadBookService readBookService, AlterBookService alterBookService,
			ReadBookDao readBookDao, BooksDao booksDao, MemberDao memberDao,
			MemberBCodesManagerDao memberBCodesManagerDao, TimeCalculationService timeCalculationService) {
		super();
		this.readBookService = readBookService;
		this.alterBookService = alterBookService;
		this.readBookDao = readBookDao;
		this.booksDao = booksDao;
		this.memberDao = memberDao;
		this.memberBCodesManagerDao = memberBCodesManagerDao;
		this.timeCalculationService=timeCalculationService;
	}

	@Autowired
	public ReadBookVO makeReadBookVO() {
		return new ReadBookVO();
	}
	
	@Autowired
	public BooksVO makeBooksVO() {
		return new BooksVO();
	}
	
	@RequestMapping(value = "/updateReadBook", method=RequestMethod.GET)
	public String updateReadBook(@RequestParam("rb_seq") String strRb_seq, 
			@ModelAttribute("readBookVO") ReadBookVO readBookVO, HttpSession httpSession, Model model) {
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		long rb_seq=-1;
		try {
			rb_seq=Long.valueOf(strRb_seq);
		} catch (Exception e) {
			log.debug("!!! updateReadBook get controller 자료형 변환중 에러");
		}
		readBookVO=readBookService.findReadBookByRb_seq(rb_seq);
		model.addAttribute("readBookVO", readBookVO);
		model.addAttribute("_m_id", memberVO.getM_id());
		model.addAttribute("MODE","UPDATE");
		model.addAttribute("MODAL","UPDATE");
		log.debug("!!! readbookvo vals get:"+readBookVO.toString());
		return "/detailview";
	}
	
	@RequestMapping(value = "/updateReadBookAjx", method=RequestMethod.POST)
	public String updateReadBookAjx(@RequestParam("rb_seq") String strRb_seq, 
			@ModelAttribute("readBookVO") ReadBookVO readBookVO, Model model) {
		long rb_seq=-1;
		try {
			rb_seq=Long.valueOf(strRb_seq);
		} catch (Exception e) {
			log.debug("!!! updateReadBook get controller 자료형 변환중 에러");
		}
		readBookVO=readBookService.findReadBookByRb_seq(rb_seq);
		model.addAttribute("readBookVO", readBookVO);
		model.addAttribute("MODE","UPDATE");
		log.debug("!!! readbookvo vals get:"+readBookVO.toString());
		return "/alterReadBook";
	}
	
	@RequestMapping(value = "/updateReadBook", method=RequestMethod.POST)
	public String updateReadBook(@ModelAttribute("readBookVO") ReadBookVO readBookVO, 
			String _m_id,Model model) {
		log.debug("!!! updatebook post called");
		long rb_seq=-1;
		try {
			rb_seq=Long.valueOf(readBookVO.getRb_seq());
		} catch (Exception e) {
			log.debug("!!! updateReadBook post controller 자료형 변환중 에러");
		}
		String b_code=readBookVO.getRb_bcode();
		
		log.debug("!!! b4 update");
		int ret=alterBookService.updateReadBook(readBookVO);
		log.debug("!!! after update");
		
		model.addAttribute("rb_seq", rb_seq);
		model.addAttribute("m_id", _m_id);
		return "redirect:/readbook/myBookList";
	}
	
	@RequestMapping(value = "/insertReadBook",method=RequestMethod.GET)
	public String insertReadBook(@ModelAttribute("readBookVO") ReadBookVO readBookVO,String _b_code,
			Model model, HttpSession httpSession) {
		readBookVO=alterBookService.makeNewReadBookVO(_b_code,httpSession);
		readBookVO.setRb_date(timeCalculationService.getCurDate());
		readBookVO.setRb_stime(timeCalculationService.getCurTime());
		model.addAttribute("readBookVO", readBookVO);
		return "/insertReadBook";
	}
	
	@RequestMapping(value = "/insertReadBook",method=RequestMethod.POST)
	public String insertReadBook(@ModelAttribute("readBookVO") ReadBookVO readBookVO, 
			HttpSession httpSession, Model model) {
		log.debug("!!! insertReadBook post called");
		log.debug(readBookVO.toString());
		BooksVO booksVO=booksDao.selectByBCode(readBookVO.getRb_bcode());
		int ret=alterBookService.insertReadBook(booksVO,httpSession,readBookVO);
		model.addAttribute("readBookVO", readBookVO);
		model.addAttribute("b_name", booksVO.getB_name());
		log.debug("!!! psersonReadBook get readBookVO:"+readBookVO.toString() );
		return "redirect:/readbook/simpleViewList";
	}
	
	@RequestMapping(value = "/deleteBook",method=RequestMethod.POST)
	public String deleteBook(String _b_code) {
		booksDao.delete(_b_code);
		return "redirect:/readbook/showalllist";
	}
	
	@RequestMapping(value = "/insertBook",method=RequestMethod.GET)
	public String insertBook(@ModelAttribute("booksVO") BooksVO booksVO,Model model) {
		booksVO=new BooksVO();
		model.addAttribute("booksVO", booksVO);
		return "/insertBook";
	}
	
	@RequestMapping(value = "/insertBook",method=RequestMethod.POST)
	public String insertBook(@ModelAttribute("booksVO") BooksVO booksVO,Model model, String post) {
		int ret=booksDao.insert(booksVO);
		return "redirect:/readbook/viewAllBooks";
	}
	
	@RequestMapping(value = "/updateBook",method=RequestMethod.GET)
	public String updateBook(@ModelAttribute("booksVO") BooksVO booksVO, String _b_code,Model model) {
		log.debug("!!! updateBook get control");
		booksVO=booksDao.selectByBCode(_b_code);
		model.addAttribute("booksVO", booksVO);
		return "/updateBook";
	}
	
	@RequestMapping(value = "/updateBook",method=RequestMethod.POST)
	public String updateBook(@ModelAttribute("booksVO") BooksVO booksVO, Model model) {
		int ret=booksDao.update(booksVO);
		return "redirect:/readbook/viewAllBooks";
	}
}
