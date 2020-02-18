package com.biz.crawl.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.crawl.domain.NaverMovieVO;
import com.biz.crawl.service.MovieCrawlService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/naver")
public class NaverMovieCrawlController {
	private final MovieCrawlService mcService;
	
	@RequestMapping(value = "/rank",method=RequestMethod.GET)
	public List<NaverMovieVO> rank() {
		List<NaverMovieVO> naverList=mcService.selectAll();
		return naverList;
	}
}
