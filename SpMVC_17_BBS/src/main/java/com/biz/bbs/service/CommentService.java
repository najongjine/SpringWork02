package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.domain.CommentVO;
import com.biz.bbs.mapper.CommentDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentService {
	private final CommentDao cmmDao;

	public int insert(CommentVO cmmVO) {
		int ret=cmmDao.insert(cmmVO);
		return ret;
	}

	public List<CommentVO> selectAll(long cmt_p_id) {
		// TODO Auto-generated method stub
		return cmmDao.selectAll(cmt_p_id);
	}
}
