package com.biz.pet.persistence;

import java.util.List;

import com.biz.pet.domain.HospitalDTO;
import com.biz.pet.domain.HospitalPageDTO;

public interface HospitalDao {

	public long hTotalCount();
	
	public List<HospitalDTO> selectAll();
	public List<HospitalDTO> findBysearch(HospitalDTO hDTO);
	public HospitalDTO findbyId(long h_seq);
	
	public List<HospitalDTO> selectPagination(HospitalPageDTO pageDTO);
	
	public int insert(HospitalDTO hDTO);
	public int update(HospitalDTO hDTO);
	public int delete(long h_seq);
	

}
