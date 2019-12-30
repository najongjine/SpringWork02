package com.biz.pet.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.HospitalDTO;
import com.biz.pet.domain.HospitalPageDTO;
import com.biz.pet.persistence.HospitalDao;

@Service
public class HospitalService {

	@Autowired
	SqlSession sqlSession;
	
	HospitalDao hDao;
	
	@Autowired
	public void getMapper() {
		hDao = sqlSession.getMapper(HospitalDao.class);
	}
	
	
	public long totalCount() {
		return hDao.hTotalCount();
	}
	
	public List<HospitalDTO> getAllList() {
		// 전체 병원리스트를 DB에서 가져와서 Controller로 return
		List<HospitalDTO> hList = hDao.selectAll();
		return hList;
	}

	public List<HospitalDTO> getSearchList(String h_name) {
		// 병원이름으로 검색하기
		HospitalDTO hDTO = HospitalDTO.builder().h_name(h_name).build();
		return hDao.findBysearch(hDTO);
	}

	public HospitalDTO getList(long h_seq) {

		HospitalDTO hDTO = hDao.findbyId(h_seq);
		return hDTO;
	}
	
	public List<HospitalDTO> selectPagination(HospitalPageDTO pageDTO) {
		List<HospitalDTO> hpList = hDao.selectPagination(pageDTO);
		return hpList;
	}


	public HospitalDTO findBySeq(long h_seq) {
		HospitalDTO hDTO = hDao.findbyId(h_seq);
		return hDTO;
	}
	
	public int insert(HospitalDTO hDTO) {
		return hDao.insert(hDTO);
	}

	public int update(HospitalDTO hDTO) {
		int ret = hDao.update(hDTO);
		return ret;
	}


	public int delete(long h_seq) {
		int ret = hDao.delete(h_seq);
		return 0;
	}
	
}
