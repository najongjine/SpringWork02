package com.biz.pet.service.simplediag.lung;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pet.domain.najongjinutil.JongPageDTO;
import com.biz.pet.domain.simplediag.lung.LungDTO;
import com.biz.pet.domain.simplediag.lung.LungExplDTO;
import com.biz.pet.persistence.simplediag.lung.LungDao;
import com.biz.pet.persistence.simplediag.lung.LungExplDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LungService {
	long maxListSize=0;
	@Autowired
	SqlSession SqlSession;
	@Autowired
	LungPageService pService;
	
	LungDao lungDao;
	LungExplDao leDao;
	@Autowired
	public void makeLungDao() {
		lungDao=SqlSession.getMapper(LungDao.class);
	}
	@Autowired
	public void makeLungExplDao() {
		leDao=SqlSession.getMapper(LungExplDao.class);
	}
	public JongPageDTO getPage(String cat, String search, long currentPageNo) {
		long totalCount=maxListSize;
		if(totalCount>maxListSize) totalCount=maxListSize;
		JongPageDTO pageDTO=pService.makePageNation(totalCount, currentPageNo);
		log.debug("전체갯수: "+totalCount);
		
		return pageDTO;
	}
	public List<LungDTO> findAllList() {
		// TODO Auto-generated method stub
		List<LungDTO> lungList=lungDao.findAll();
		maxListSize=lungList.size();
		
		for(LungDTO lungDTO: lungList) {
			String lung_e_code=lungDTO.getLung_explcode();
			List<LungExplDTO> leList=leDao.findByLECODE(lung_e_code);
			for(LungExplDTO leDTO: leList) {
				lungDTO.getExplList().add(leDTO);
			}
		}
		return lungList;
	}
	public LungDTO findBySeq(long lung_seq) {
		LungDTO lungDTO=lungDao.findBySeq(lung_seq);
		String lung_e_code="";
		try {
			lung_e_code=lungDTO.getLung_explcode();
		} catch (Exception e) {
			// TODO: handle exception
			lung_e_code="-1";
		}
		List<LungExplDTO> leList=leDao.findByLECODE(lung_e_code);
		for(LungExplDTO leDTO: leList) {
			lungDTO.getExplList().add(leDTO);
		}
		return lungDTO;
	}
	public int delete(long lung_seq) {
		String lung_e_code="";
		LungDTO lungDTO=lungDao.findBySeq(lung_seq);
		lung_e_code=lungDTO.getLung_explcode();
		leDao.deleteByLECode(lung_e_code);
		return lungDao.delete(lung_seq);
	}
	public int update(LungDTO lungDTO) {
		// TODO Auto-generated method stub
		return lungDao.update(lungDTO);
	}
	public int insert(LungDTO lungDTO) {
		// TODO Auto-generated method stub
		String maxLeCode=lungDao.selectMaxLECode();
		log.debug("!!! maxlecode: "+maxLeCode);
		String prefix=maxLeCode.substring(0,3);
		int suffix=Integer.valueOf(maxLeCode.substring(3));
		suffix++;
		log.debug("!!! suffix: "+suffix);
		String increLeCode=prefix+(String.format("%04d", suffix));
		log.debug("!!! increLeCode: "+ increLeCode);
		lungDTO.setLung_explcode(increLeCode);
		return lungDao.insert(lungDTO);
	}
}
