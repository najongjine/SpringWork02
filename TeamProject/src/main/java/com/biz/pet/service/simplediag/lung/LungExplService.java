package com.biz.pet.service.simplediag.lung;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.simplediag.lung.LungExplDTO;
import com.biz.pet.persistence.simplediag.lung.LungExplDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LungExplService {
	@Autowired
	SqlSession sqlSession;
	LungExplDao leDao;
	
	@Autowired
	public void makeLungExplDao() {
		leDao=sqlSession.getMapper(LungExplDao.class);
	}
	
	public int update(String[] currentStrExpl,String lung_e_code) {
		List<LungExplDTO> leList=leDao.findByLECODE(lung_e_code);
		int ret=0,i=0;
		for(LungExplDTO leDTO:leList) {
			leDTO.setLung_e_expl(currentStrExpl[i++].trim());
			ret=leDao.update(leDTO);
		}
		leList=leDao.findByLECODE(lung_e_code);
		for(LungExplDTO leDTO:leList) {
			if(leDTO.getLung_e_expl()==null) {
				ret=leDao.delete(leDTO);
			}
		}
		return ret;
	}

	public int insert(String[] newStrExpl, String lung_e_code,String lung_e_name) {
		int ret=0;
		LungExplDTO leDTO=null;
		if(newStrExpl==null) return -1;
		for(String s:newStrExpl) {
			if(s.trim().length()<1) {
				continue;
			}
			//LungExplDTO leDTO.lung_e_expl(s).lung_e_name(lung_e_name).lung_e_code(lung_e_code).build();
			leDTO=new LungExplDTO();
			leDTO.setLung_e_expl(s);
			leDTO.setLung_e_name(lung_e_name);
			leDTO.setLung_e_code(lung_e_code);
			log.debug("!!! insert service newexpldto: "+leDTO.toString());
			ret=leDao.insert(leDTO);
		}
		return ret;
	}
}
