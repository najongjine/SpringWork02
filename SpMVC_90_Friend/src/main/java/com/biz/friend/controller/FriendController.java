package com.biz.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.domain.util.PageDTO;
import com.biz.friend.domain.util.SearchVO;
import com.biz.friend.repository.FriendDao;
import com.biz.friend.service.FriendService;
import com.biz.friend.service.util.PageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/friend")
@SessionAttributes("{friendVO,searchVO}")
public class FriendController {
	private final FriendService friendService;
	private final PageService pageService;
	private final FriendDao friendDao;
	
	private int offset=0;
	private int limit=10;
	
	@Autowired
	public FriendVO makeFriendVO() {
		return new FriendVO();
	}
	@Autowired
	public SearchVO makeSearchVO() {
		return new SearchVO();
	}
	
	@RequestMapping(value = "/showAll",method=RequestMethod.GET)
	public String showAll(Model model,@ModelAttribute SearchVO searchVO,@RequestParam(value = "currentPageNo", required = false,
			defaultValue = "1") int currentPageNo) {
		//offset : DB에서 찾았을때 튜플 시작 번호
		//limit: offset 으로부터 몇개를 보여줄 것인가.
		//offset에서 시작해서 limit 까지 select 하고나면 다음번은 limit 거리 만큼 띄어서 또 가져와야함.
		offset=(currentPageNo-1)*limit;
		
		//pagenation.jsp 에 번호들을 보여줄 정보를 담은 DTO
		PageDTO pageDTO=null;
		
		//검색했을시 검색 유지 옵션을 담을 searchVO. 한 테이블당 해당 
		String searchOption=searchVO.getSearchOption();
		
		//페이지 번호를 클릭시 유저가 검색한 데이터를 ping pong 형태로 주고 다시 받는다.
		model.addAttribute("searchVO", searchVO);
		
		List<FriendVO> friendList=null;
		
		if(searchOption.equalsIgnoreCase("nameSearch")) {
			// pagination.jsp 밑에 숫자들을 계산해주는 service. 첫번째 인자는 원하는 레코드들의 전체 갯수,
			//두번째 인자는 현재 페이지 번호
			pageDTO=pageService.makePageNation(friendDao.countFindByf_name(searchVO.getInputStr()), currentPageNo);
			
			//화면에 limit 만큼 지정한 데이터를 뿌려줄 service.
			friendList=friendService.findByf_name(searchVO.getInputStr(),limit,offset );
		}
		else {
			pageDTO=pageService.makePageNation(friendDao.countAll(), currentPageNo);
			friendList=friendService.selectAll(limit,offset);
		}
		
		//화면에 뿌려줄 데이터
		model.addAttribute("friendList", friendList);
		
		//pagination.jsp 에 보여줄 숫자
		model.addAttribute("PAGE", pageDTO);
		return "/friend/showAll";
	}
	
	@RequestMapping(value = "/viewDetail")
	public String viewDetail(@ModelAttribute FriendVO friendVO,Model model) {
		friendVO=friendService.findByID(friendVO.getF_id());
		model.addAttribute("friendVO", friendVO);
		return "/friend/viewDetail";
	}
	
	@RequestMapping(value = "/updateForm",method=RequestMethod.POST)
	public String updateForm(@ModelAttribute FriendVO friendVO,Model model) {
		model.addAttribute("mode", "update");
		model.addAttribute("friendVO", friendService.findByID(friendVO.getF_id()));
		return "/friend/input";
	}
	
	@RequestMapping(value = "/updateDB",method=RequestMethod.POST)
	public String updateDB(@ModelAttribute FriendVO friendVO,Model model) {
		friendService.update(friendVO);
		model.addAttribute(friendVO);
		return "/friend/viewDetail";
	}
	
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute FriendVO friendVO, Model model) {
		friendVO=makeFriendVO();
		model.addAttribute("mode", "insert");
		model.addAttribute("friendVO", friendVO);
		return "friend/input";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute FriendVO friendVO) {
		friendService.insert(friendVO);
		return "redirect:/friend/showAll";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	public String delete(@ModelAttribute FriendVO friendVO) {
		int ret=friendService.delete(friendVO.getF_id());
		return "success";
	}
}
