package com.biz.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.bbs.domain.BBsVO;
import com.biz.bbs.mapper.BBsDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service("bServiceV1")
public class BBsServiceImpV1 implements BBsService{
	protected final BBsDao bbsDao;

	@Override
	public List<BBsVO> selectAll() {
		// TODO Auto-generated method stub
		//return bbsDao.selectAll();
		return bbsDao.selectMain();
	}

	@Override
	public BBsVO findById(long bbs_id) {
		// TODO Auto-generated method stub
		return bbsDao.findById(bbs_id);
	}

	@Override
	public List<BBsVO> findBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BBsVO> findByWriter(String writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BBsVO> findBySubAndWriter(String subject, String writer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(BBsVO bbsVO) {
		long bbs_id=bbsVO.getBbs_id();
		if(bbs_id>0) {
			bbsDao.update(bbsVO);
		} else {
			bbsDao.insert(bbsVO);
		}
		return 0;
	}

	@Override
	public int delete(long bbs_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BBsVO reply(BBsVO bbsVO) {
		// TODO Auto-generated method stub
		bbsVO.setBbs_p_id(bbsVO.getBbs_id());
		bbsVO.setBbs_id(0);
		String subject="re : "+bbsVO.getBbs_subject();
		bbsVO.setBbs_subject(subject);
		bbsDao.insert(bbsVO);
		return null;
	}

}
