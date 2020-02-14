package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.BookReadBookViewVO;
import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.ReadBookVO;

public interface ReadBookDao {

	@Select("select * from tbl_read_book")
	public List<ReadBookVO> selectAll();
	
	@Select("select B_CODE, " + 
			"B_NAME, " + 
			"B_AUTHER, " + 
			"B_COMP, " + 
			"B_YEAR, " + 
			"B_IPRICE from tbl_books where b_code=#{rb_bcode}")
	public List<BooksVO> findAllByBCode(String rb_bcode);
	
	@Select("select * from tbl_read_book where RB_SEQ=#{rb_seq}")
	public ReadBookVO findByRB_SEQ(long rb_seq);
	
	@Select("select distinct " + 
			"RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, " + 
			"b_name " + 
			"from tbl_books,tbl_read_book " + 
			"where b_code=rb_bcode " + 
			"group by RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, " + 
			"b_name ")
	public List<BookReadBookViewVO> selectAllBookReadBookView();
	
	@Select("select distinct " + 
			"RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, " + 
			"b_name " + 
			"from tbl_books,tbl_read_book " + 
			"where b_code=rb_bcode " + 
			"and b_name like '%' || #{b_name} || '%' " + 
			"group by RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, " + 
			"b_name")
	public List<BookReadBookViewVO> findAllBybNameBookReadBookView(String b_name);
	
	@Select("select distinct " + 
			"RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, " + 
			"b_name " + 
			"from tbl_books,tbl_read_book " + 
			"where b_code=rb_bcode " + 
			"and b_code=#{b_code} " + 
			"group by RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, " + 
			"b_name")
	public List<BookReadBookViewVO> findAllByBCodeBookReadBookView(String b_code);
	
	@InsertProvider(type = ReadBookSQL.class,method = "insertSQL")
	public int insert(ReadBookVO readBookVO);
	
	@UpdateProvider(type = ReadBookSQL.class,method = "updateSQL")
	public int update(ReadBookVO readBookVO);
	
	@Delete("delete from tbl_read_book where rb_seq=#{rb_seq}")
	public int delete(long rb_seq);

	@Select("select * from tbl_read_book where rb_seq= (select max(rb_seq) from tbl_read_book)")
	public ReadBookVO findMaxRBSeq();
}
