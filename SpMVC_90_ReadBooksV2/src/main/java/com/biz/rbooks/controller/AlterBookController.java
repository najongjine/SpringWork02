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

/*
 * CRUD의 CUD 단계는 제약조건을 걸어두었다.
 * 제약조건에 쓰이는 데이터는 m_id와 m_rem을 활용하였다.
 */
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
	
	/*
	 * 책 읽기기록을 수정하는 cont.
	 * httpsession에서 유저정보와 rb_seq 값을 활용하여 수정하고자 하는 데이터만 
	 * 접근 하여 데이터를 찾고,
	 * 찾은 데이터를 detailview 페이지로 보낸다.
	 */
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
		return "/detailview";
	}
	
	/*
	 * view detail 페이지에서 읽었던 기록을 클릭하면
	 * tbl_read_book을 수정할수 있는 폼을 띄우는데,
	 * ajax 방식으로 띄우기 위해 만든 cont.
	 */
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
		return "/alterReadBook";
	}
	
	/*
	 * form에서 수정버튼을 누르면 불려지는 cont.
	 * 서비스로 가서 다오에서 update 함수를 호출후
	 * update 함수에서 update sql을 수행후 
	 * tbl_read_book update 완료
	 */
	@RequestMapping(value = "/updateReadBook", method=RequestMethod.POST)
	public String updateReadBook(@ModelAttribute("readBookVO") ReadBookVO readBookVO, 
			String _m_id,Model model) {
		
		int ret=alterBookService.updateReadBook(readBookVO);
		
		return "redirect:/readbook/myBookList";
	}
	
	/*
	 * viewAllBook 페이지에서 책 읽기 버튼을 클릭하면 불려질 cont.
	 * 버튼을 누를시 현재 날짜와 시간을 pre setting 한다.
	 * 그리고 tbl_read_book에 새로 입력할 데이터를 입력할
	 * form 페이지가 insertReadBook에 나온다. 
	 */
	@RequestMapping(value = "/insertReadBook",method=RequestMethod.GET)
	public String insertReadBook(@ModelAttribute("readBookVO") ReadBookVO readBookVO,String _b_code,
			Model model, HttpSession httpSession) {
		readBookVO=alterBookService.makeNewReadBookVO(_b_code,httpSession);
		readBookVO.setRb_date(timeCalculationService.getCurDate());
		readBookVO.setRb_stime(timeCalculationService.getCurTime());
		model.addAttribute("readBookVO", readBookVO);
		return "/insertReadBook";
	}
	
	/*
	 * insertReadBook 페이지에서 '책 다 읽음' 버튼을 눌렀을시 불려질 cont.
	 * '책 다 읽음'을 누르면 눌렀던 시간ㅇㄹ 자동으로 계산하고,
	 * 이 버튼을 누르기 전의 시간과 누른후 시간의 차이를 계산해서
	 * rb_rtime 에 총 읽은 시간을 기록한다.
	 *
	 * 그후 메인화면으로 리다이렉트 시켰다.
	 */
	@RequestMapping(value = "/insertReadBook",method=RequestMethod.POST)
	public String insertReadBook(@ModelAttribute("readBookVO") ReadBookVO readBookVO, 
			HttpSession httpSession, Model model) {
		// tbl_read_book 테이블엔 책 이름이 없기때문에 
		//tbl_book에서 이름을 찾아냈다.
		BooksVO booksVO=booksDao.selectByBCode(readBookVO.getRb_bcode());
		
		//서비스에서 insert를 수행한다. m_id는 httpSession에서 뽑는다.
		int ret=alterBookService.insertReadBook(booksVO,httpSession,readBookVO);
		
		model.addAttribute("readBookVO", readBookVO);
		model.addAttribute("b_name", booksVO.getB_name());
		return "redirect:/readbook/simpleViewList";
	}
	
	/*
	 * 책을 추가 form 페이지를 띄우는 cont
	 * ADMIN권할일때 책 추가 form이 보이게 하였다.
	 * httpSession에서 memberVO의 m_rem값을 참조하였다.
	 */
	@RequestMapping(value = "/insertBook",method=RequestMethod.GET)
	public String insertBook(@ModelAttribute("booksVO") BooksVO booksVO,Model model
			,HttpSession httpSession) {
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		String m_rem=memberVO.getM_rem();
		if(!m_rem.equalsIgnoreCase("ADMIN")) {
			return null;
		}
		
		//booksVO를 새로 만들어서 insert 페이지에 넘겨줌
		booksVO=new BooksVO();
		model.addAttribute("booksVO", booksVO);
		return "/insertBook";
	}
	
	/*
	 * 책 추가 form에서 추가 버튼을 눌렀을시 불려지는 method
	 * 
	 * 책 추가후 viewAllBooks 페이지로 이동한다.
	 * 
	 */
	@RequestMapping(value = "/insertBook",method=RequestMethod.POST)
	public String insertBook(@ModelAttribute("booksVO") BooksVO booksVO,Model model, String post
			) {
		int ret=0;
		try {
			// 특별히 넘겨온 데이터를 따로 손봐야할 일이 없어서
			//service를 거치지 않고 바로 dao로 통해서 insert 하였다.
			// service 내부에 코드를 줄이고자 이렇게 하였다.
			ret=booksDao.insert(booksVO);
		} catch (Exception e) {
			log.debug("이미 입력된 bcode임");
		}
		
		return "redirect:/readbook/viewAllBooks";
	}
	
	/*
	 * 책을 수정하는건 ADMIN 권한만 가능하게 하였다. ADMIN계정이 아니면 
	 * 책 수정 폼을 불러들일수 없게 하였다.
	 */
	@RequestMapping(value = "/updateBook",method=RequestMethod.GET)
	public String updateBook(@ModelAttribute("booksVO") BooksVO booksVO, String _b_code,Model model
			,HttpSession httpSession) {
		MemberVO memberVO=(MemberVO) httpSession.getAttribute("memberVO");
		String m_rem=memberVO.getM_rem();
		if(!m_rem.equalsIgnoreCase("ADMIN")) {
			return null;
		}
		booksVO=booksDao.selectByBCode(_b_code);
		model.addAttribute("booksVO", booksVO);
		return "/updateBook";
	}
	
	/*
	 * 책을 수정할때는 여러가지 값을 한꺼번에,
	 *  서버작동 정보를 최대한 숨기기 위해,
	 *  스크립트 없이 쉽게 받기위해 
	 *  form 태그의 POST방식으로 받았다.
	 */
	@RequestMapping(value = "/updateBook",method=RequestMethod.POST)
	public String updateBook(@ModelAttribute("booksVO") BooksVO booksVO, Model model) {
		int ret=booksDao.update(booksVO);
		return "redirect:/readbook/viewAllBooks";
	}
}
