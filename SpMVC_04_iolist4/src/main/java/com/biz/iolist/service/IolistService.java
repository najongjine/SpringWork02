package com.biz.iolist.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;
import com.biz.iolist.persistence.IolistDao;

@Service
public class IolistService {
	@Autowired
	SqlSession sqlSession;
	
	IolistDao ioDao;
	@Autowired
	public void getMapper() {
		ioDao=sqlSession.getMapper(IolistDao.class);
	}
	
	public List<IolistVO> viewFindAll(){
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		List<IolistVO> iolist=ioDao.viewFindAll();
		return iolist;
	}
	public List<IolistDTO> findAll(){
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		List<IolistDTO> iolistList=ioDao.findAll();
		return iolistList;
	}
	public IolistVO viewFindById(long io_seq){
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		IolistVO iolistVO=ioDao.viewFindById(io_seq);
		return iolistVO;
	}
	public IolistDTO findFindId(long io_seq) {
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		IolistDTO iolistDTO=ioDao.findFindId(io_seq);
		return iolistDTO;
	}
	public int insert(IolistDTO iolistDTO) {
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		int ret=ioDao.insert(iolistDTO);
		return ret;
	}
	public int update(IolistDTO iolistDTO) {
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		int ret=ioDao.update(iolistDTO);
		return ret;
	}
	public int delete(long io_seq) {
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		int ret=ioDao.delete(io_seq);
		return ret;
	}
	public List<IolistVO> viewAllList() {
		//ioDao ioDao=sqlSession.getMapper(ioDao.class);
		List<IolistVO> iolist=ioDao.viewSelectAll();
		return iolist;
	}
	public IolistVO findBySeq(long io_seq) {
		IolistVO ioVO=ioDao.findBySeq(io_seq);
		return ioVO;
	}
}
