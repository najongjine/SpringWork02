package com.biz.pet.service.community;

import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.community.PageDTO;
import com.biz.pet.domain.community.ReviewDTO;
import com.biz.pet.domain.community.ServiceDTO;
import com.biz.pet.persistence.community.ServiceDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	PageService pService;

	ServiceDao sDao;

	@Autowired
	public void getMapper() {
		sDao = sqlSession.getMapper(ServiceDao.class);
	}

	public long totalCount(String se_subject) {

		String[] se_subjects = se_subject.split(" ");
		
		List<String> se_subList = Arrays.asList(se_subjects);
		return sDao.proTotalCount(se_subList);
		
	}
	
	public List<ServiceDTO> findBySSubjectListAndPagiNation(String se_subject, PageDTO pageDTO) {

		List<String> se_subjects = Arrays.asList(se_subject.split(" "));
		return sDao.findBySSubjectListAndPagiNation(se_subjects, pageDTO);
		
	}
	
	public List<ServiceDTO> selectPagination(PageDTO pageDTO) {
		List<ServiceDTO> seList = sDao.selectPagination(pageDTO);
		return seList;
	}
	
	public List<ServiceDTO> getAllList() {
		List<ServiceDTO> seList = sDao.selectAll();
		
		return sDao.selectAll();
	}

	public int insert(ServiceDTO seDTO) {
		return sDao.insert(seDTO);
	}

	public ServiceDTO getService(long se_seq) {
		ServiceDTO seDTO = sDao.findById(se_seq);
		return seDTO;
	}

	public int update(ServiceDTO seDTO) {
		return sDao.update(seDTO);
	}

	public int delete(long se_seq) {
		return sDao.delete(se_seq);
	}
	
	
	
	
	
	/*
	 * 	
	long maxListSize = 0;
	
	@Autowired
	PageService pService;
	
	 * 
	 * 	public List<ReviewDTO> getAllList() {
		List<ReviewDTO> reList = rDao.selectAll();
		// maxListSize = reList.size();
		
		return rDao.selectAll();
	}
	
	
	
	public PageDTO getPage(long currentPageNo) {
		

		long maxSize = maxListSize;
		if(maxSize > maxListSize) maxSize = maxListSize;
		PageDTO pageDTO = pService.makePagination(maxSize, currentPageNo);
		
		
		return pageDTO;
	}
	
	
	
	

	
	public ReviewDTO getReview(long re_seq) {

		
	
	}

	public int update(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return rDao.update(reviewDTO);
	}

	public int delete(long re_seq) {
		// TODO Auto-generated method stub
		
	}
*/
}
