package com.biz.crawl.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.crawl.domain.NaverMovieVO;
import com.biz.crawl.service.MovieCrawlService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {
	private final MovieCrawlService mcService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		List<NaverMovieVO> naverList=mcService.movieRankGet();
		model.addAttribute("NAVER_LIST", naverList);
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET,produces = "text/html; charset=utf8")
	public String test() {
		
		String strHtml=mcService.myCrawl();
		//String strHtml="test conteroller";
		log.debug("!!! test controller");
		return strHtml;
	}
	
}
