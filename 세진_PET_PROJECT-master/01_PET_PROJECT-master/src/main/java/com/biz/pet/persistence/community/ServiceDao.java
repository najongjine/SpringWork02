package com.biz.pet.persistence.community;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.biz.pet.domain.community.PageDTO;
import com.biz.pet.domain.community.ServiceDTO;

public interface ServiceDao {
	
	public List<ServiceDTO> selectAll();
	
	public long proTotalCount(@Param("se_subject") List<String> se_subList) ;
	
	// offset부터 limit까지의 데이터만 추출
	public List<ServiceDTO> selectPagination(PageDTO pageDTO);
	
	public ServiceDTO findById(long se_seq);

	public int insert(ServiceDTO seDTO);

	public int update(ServiceDTO seDTO);

	public int delete(long se_seq);
	
	public List<ServiceDTO> findBySSubjectListAndPagiNation(
			@Param("se_subject") List<String> se_subjects, 
			@Param("pageDTO") PageDTO pageDTO);
	
}
