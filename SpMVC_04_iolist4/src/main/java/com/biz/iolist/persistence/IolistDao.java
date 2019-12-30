package com.biz.iolist.persistence;

import java.util.List;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;

public interface IolistDao {
	public List<IolistVO> viewFindAll();
	public List<IolistDTO> findAll();
	public IolistVO viewFindById(long io_seq);
	public IolistDTO findFindId(long io_seq);
	public int insert(IolistDTO iolistDTO);
	public int update(IolistDTO iolistDTO);
	public int delete(long io_seq);
	public List<IolistVO> viewSelectAll();
	public IolistDTO findById(long io_seq);
	public IolistVO findBySeq(long io_seq);
}
