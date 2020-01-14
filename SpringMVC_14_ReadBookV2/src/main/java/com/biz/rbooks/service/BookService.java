package com.biz.rbooks.service;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.BookVO;
import com.biz.rbooks.repository.BookDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * private final로 설정된 필드 변수들의
 * 생성자를 생성하고 자동 inject(@autowired)를 수행해 준다.
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class BookService {
	private final BookDao bookDao;

	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		return bookDao.selectAll();
	}

	public int insert(BookVO bookVO) {
		Random rnd=new Random();
		String b_code=rnd.nextGaussian()+"";
		bookVO.setB_code(b_code);
		bookVO.setB_auther("연습하기");
		bookVO.setB_name("aaa");
		return bookDao.insert(bookVO);
	}
}
