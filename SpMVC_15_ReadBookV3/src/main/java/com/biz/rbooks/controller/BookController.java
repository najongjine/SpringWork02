package com.biz.rbooks.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.service.BookService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value = "/book")
@RequiredArgsConstructor
public class BookController {
	private final BookService bService;
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public List<BookVO> list(){
		return bService.selectAll();
	}

}
