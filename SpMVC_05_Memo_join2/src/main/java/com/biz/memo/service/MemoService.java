package com.biz.memo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.memo.domain.MemoDTO;
import com.biz.memo.persistence.MemoDao;

@Service
public class MemoService {
	@Autowired
	SqlSession sqlSession;
	
	MemoDao mDao;
	
	@Autowired
	public void getMapper() {
		mDao=sqlSession.getMapper(MemoDao.class);
	}

	public List<MemoDTO> getAllList() {
		List<MemoDTO> memoList=mDao.selectAll();
		return memoList;
	}

	public List<MemoDTO> getSearchList(String m_subject) {
		// TODO Search with Subject
		MemoDTO memoDTO=MemoDTO.builder().m_subject(m_subject).build();
		return mDao.findBySearch(memoDTO);
	}

	public int insert(MemoDTO memoDTO) {
		return mDao.insert(memoDTO);
	}

	public MemoDTO getMemo(long m_seq) {
		MemoDTO memoDTO=mDao.findById(m_seq);
		return memoDTO;
	}

	public int update(MemoDTO memoDTO) {
		
		return mDao.update(memoDTO);
	}

	public int delete(long m_seq) {
		
		return mDao.delete(m_seq);
	}
}
