package com.biz.rbooks.service;

import java.util.Arrays;
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

	public List<BookVO> findByBNames(String strText) {
		/*
		 * strText를 빈칸으로 분해해서 문자열 배열을 만들고
		 * 그 배열을 List<String> 열으로 변환한다음 names List에 담아라.
		 */
		List<String> names=Arrays.asList(strText.split(" "));
		int ret=0;
		List<BookVO> bookList=bookDao.findByNames(names);
		return bookList;
	}

	public BookVO findByBCode(String b_code) {
		// TODO Auto-generated method stub
		return bookDao.findByBCode(b_code);
	}
}
