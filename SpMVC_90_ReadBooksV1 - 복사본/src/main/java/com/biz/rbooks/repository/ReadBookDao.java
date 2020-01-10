package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.ReadBookVO;

public interface ReadBookDao {

	@Select("select * from tbl_read_book")
	public List<ReadBookVO> selectAll();
	
	@Select("select * from tbl_read_book where RB_SEQ=#{rb_seq}")
	public ReadBookVO findByRB_SEQ(long rb_seq);
	
	@InsertProvider(type = ReadBookSQL.class,method = "insertSQL")
	public int insert(ReadBookVO readBookVO);
	
	@UpdateProvider(type = ReadBookSQL.class,method = "updateSQL")
	public int update(ReadBookVO readBookVO);
	
	@Delete("delete from tbl_read_book where rb_seq=#{rb_seq}")
	public int delete(long rb_seq);
}
