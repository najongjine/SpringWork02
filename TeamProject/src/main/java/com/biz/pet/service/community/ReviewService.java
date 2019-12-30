package com.biz.pet.service.community;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.community.PageDTO;
import com.biz.pet.domain.community.ReviewDTO;
import com.biz.pet.persistence.community.ReviewDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	PageService pService;
		
	ReviewDao rDao;

	@Autowired
	public void getMapper() {
		rDao = sqlSession.getMapper(ReviewDao.class);
	}
	
	public long totalCount(String re_subject) {

		String[] re_subjects = re_subject.split(" ");
		
		List<String> re_subList = Arrays.asList(re_subjects);
		return rDao.proTotalCount(re_subList);
		
	}
	
	public List<ReviewDTO> findByRSubjectListAndPagiNation(String re_subject, PageDTO pageDTO) {

		List<String> re_subjects = Arrays.asList(re_subject.split(" "));
		return rDao.findByRSubjectListAndPagiNation(re_subjects,pageDTO);
		
	}
	
	public List<ReviewDTO> selectPagination(PageDTO pageDTO) {
		List<ReviewDTO> reList = rDao.selectPagination(pageDTO);
		return reList;
	}
	
	public List<ReviewDTO> selectAll() {
		List<ReviewDTO> reList = rDao.selectAll();
		
		return rDao.selectAll();
	}

	public int insert(ReviewDTO reDTO) {
		return rDao.insert(reDTO);
	}

	public ReviewDTO getReview(long re_seq) {
		ReviewDTO reDTO = rDao.findById(re_seq);
		return reDTO;
	}

	public int update(ReviewDTO reDTO) {
		return rDao.update(reDTO);
	}

	public int delete(long re_seq) {
		return rDao.delete(re_seq);
	}


}
