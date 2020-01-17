package com.biz.rbooks.respository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.ReadBookVO;

public interface ReadBookDao {

	@Select("select * from tbl_read_book")
	public List<ReadBookVO> selectAll();

}
