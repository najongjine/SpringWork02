package com.biz.pet.persistence.community;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.pet.domain.community.PageDTO;
import com.biz.pet.domain.community.ReviewDTO;

public interface ReviewDao {
	
	public List<ReviewDTO> selectAll();
	
	public long proTotalCount(@Param("re_subject") List<String> re_subList);
	
	// offset부터 limit까지의 데이터만 추출
	public List<ReviewDTO> selectPagination(PageDTO pageDTO);
	
	public ReviewDTO findById(long re_seq);

	public int insert(ReviewDTO reDTO);

	public int update(ReviewDTO reDTO);

	public int delete(long re_seq);
	
	public List<ReviewDTO> findByRSubjectListAndPagiNation(
			@Param("re_subject") List<String> re_subjects, 
			@Param("pageDTO") PageDTO pageDTO);
	
}
