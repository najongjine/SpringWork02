package com.biz.pet.service.bloodtest;

import java.util.List;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.bloodtest.BloodTestDTO;
import com.biz.pet.persistence.bloodtest.BloodTestDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BloodTestService {
	@Autowired
	SqlSession sqlSession;
	BloodTestDao bldDao;
	
	@Autowired
	public void getBldDaoMapper() {
		bldDao=sqlSession.getMapper(BloodTestDao.class);
	}
	public BloodTestDTO findBySeq(long bld_seq) {
		BloodTestDTO bldDTO=bldDao.findBySeq(bld_seq);
		return bldDTO;
	}
	public List<BloodTestDTO> findAll(){
		List<BloodTestDTO> bldList=bldDao.findAll();
		return bldList;
	}
	public List<BloodTestDTO> findByName(String bld_name){
		List<BloodTestDTO> bldList=bldDao.findByName(bld_name);
		return bldList;
	}
	public int insert(BloodTestDTO bldDTO) {
		bldDTO.setBld_name(bldDTO.getBld_name().toUpperCase());
		int ret=bldDao.insert(bldDTO);
		return ret;
	}
	public int update(BloodTestDTO bldDTO) {
		bldDTO.setBld_name(bldDTO.getBld_name().toUpperCase());
		int ret=bldDao.update(bldDTO);
		return ret;
	}
	public int delete(long bld_seq) {
		int ret=bldDao.delete(bld_seq);
		return ret;
	}
	public List<BloodTestDTO> findByNameAndValue(@Valid BloodTestDTO bldDTO) {
		String bld_name=bldDTO.getBld_name();
		int inputtedValue=bldDTO.getValue();
		List<BloodTestDTO> bldList=bldDao.findByName(bld_name);
		bldList.get(0).setValue(inputtedValue);
		
		/*
		 * result of findByName is single object. Not Multiple.
		 * But because of alrdy made sql and other methods, just using List than single DTO.
		 */
		if(bldList.get(0).getBld_normalmin()>inputtedValue) {
			bldList.get(0).setCurrentStatus(bldList.get(0).getBld_belownormal());
		}
		else if(bldList.get(0).getBld_normalmax()<inputtedValue) {
			bldList.get(0).setCurrentStatus(bldList.get(0).getBld_overnormal());
		}
		else {
			bldList.get(0).setCurrentStatus("정상 수치입니다");
		}
		log.debug("!!! bdllist in serice: "+bldList.get(0).toString());
		return bldList;
	}
}
