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

public interface BooksDao {
	@Select("select * from tbl_books")
	@Results( //constraint 조건이 걸린
			value= {
				@Result(property="b_code", column = "b_code"),
				@Result(property = "readBookList", column = "b_code", javaType = List.class, 
				many=@Many(select = "findReadBookByrb_bcode"))
				}
			)
	public List<BooksVO> selectAll();
	
	@Select("select * from tbl_read_book where rb_bcode=#{b_code,jdbcType=VARCHAR}")
	public List<ReadBookVO> findReadBookByrb_bcode(String b_code);
	
	@Select("select * from tbl_books where b_code=#{b_code,jdbcType=VARCHAR}")
	@Results(
			value= {
				@Result(property="b_code", column = "b_code"),
				@Result(property = "readBookList", column = "b_code", javaType = List.class, 
				many=@Many(select = "findReadBookByrb_bcode"))
				}
			)
	public BooksVO selectByBCode(String b_code);
	
	@Select("select * from tbl_books where B_NAME like '%' || #{b_name,jdbcType=VARCHAR} || '%' ")
	public List<BooksVO> selectByBName(String b_name);
	
	@InsertProvider(type=BooksSQL.class,method = "insertSQL")
	public int insert(BooksVO booksVO);
	
	@UpdateProvider(type = BooksSQL.class,method = "updateSQL")
	public int update(BooksVO booksVO);
	
	@Delete("delete from tbl_books where b_code=#{b_code,jdbcType=VARCHAR}")
	public int delete(String b_code);
}
