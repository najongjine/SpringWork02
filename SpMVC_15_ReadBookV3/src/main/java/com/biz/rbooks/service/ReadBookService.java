package com.biz.rbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.rbooks.domain.ReadBookVO;
import com.biz.rbooks.respository.ReadBookDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReadBookService {
	private final ReadBookDao rbDao;

	public List<ReadBookVO> selectAll() {
		// TODO Auto-generated method stub
		return rbDao.selectAll();
	}

}
