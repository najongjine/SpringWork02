package com.biz.pet.persistence.simplediag.lung;

import java.util.List;

import com.biz.pet.domain.simplediag.lung.LungDTO;

import lombok.Getter;

public interface LungDao {

	public List<LungDTO> findAll();

	public LungDTO findBySeq(long lung_seq);

	public int delete(long lung_seq);

	public int update(LungDTO lungDTO);

	public int insert(LungDTO lungDTO);

	public String selectMaxLECode();
	
}
