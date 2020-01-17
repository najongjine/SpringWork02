package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.respository.BookDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
	private final BookDao bDao;
	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		return bDao.selectAll();
	}

}
