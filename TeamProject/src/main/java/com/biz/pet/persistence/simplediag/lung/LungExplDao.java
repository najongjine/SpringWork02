package com.biz.pet.persistence.simplediag.lung;

import java.util.List;

import com.biz.pet.domain.simplediag.lung.LungExplDTO;

public interface LungExplDao {
	public List<LungExplDTO> findAll();

	public List<LungExplDTO> findByLECODE(String lung_e_code);

	public int update(LungExplDTO leDTO);

	public int delete(LungExplDTO leDTO);
	public int deleteByLECode(String lung_e_code);

	public int insert(LungExplDTO leDTO);
}
