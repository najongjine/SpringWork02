package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.persistence.DeptDao;

@Service
public class DeptService {
	@Autowired
	SqlSession sqlSession;
	
	public List<DeptDTO> getAllList(){
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		List<DeptDTO> deptList=deptDao.selectAll();
		return deptList;
	}

	public int insert(DeptDTO deptDTO) {
		// TODO Auto-generated method stub
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		String maxDCode=deptDao.getDCode();
		int intDCode=Integer.valueOf(maxDCode.substring(1));
		intDCode++;
		maxDCode=maxDCode.substring(0, 1);
		maxDCode+=String.format("%04d", intDCode);
		deptDTO.setD_code(maxDCode);
		int ret=deptDao.insert(deptDTO);
		return 0;
	}

	public DeptDTO findByDCode(String d_code) {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		DeptDTO dDTO=deptDao.findByDCode(d_code);
		return dDTO;
	}

	public int delete(String d_code) {
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		deptDao.delete(d_code);
		return 0;
	}

	public int update(DeptDTO deptDTO) {
		// TODO Auto-generated method stub
		DeptDao deptDao=sqlSession.getMapper(DeptDao.class);
		int ret=deptDao.update(deptDTO);
		return ret;
	}
}
