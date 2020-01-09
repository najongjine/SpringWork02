package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.rbooks.domain.BooksVO;
import com.biz.rbooks.domain.MemberBCodesManagerVO;

public interface MemberBCodesManagerDao {
	@Select("select * from tbl_member_bcodes_manager")
	@Results(
			value= {
				@Result(property="mng_b_code", column = "mng_b_code"),
				@Result(property = "booksVO", column = "mng_b_code", javaType = List.class, 
				many=@Many(select = "findBookByBCode"))
				}
			)
	public List<MemberBCodesManagerVO> memberBCodesManagerList();
	
	@Select("select * from tbl_books where b_code=#{mng_b_code}")
	public BooksVO findBookByBCode(String mng_b_code);
	
	@Select("select * from tbl_member_bcodes_manager where mng_b_code=#{mng_b_code}")
	public MemberBCodesManagerVO findByMngBCode(String mng_b_code);
	
	@Select("select * from tbl_member_bcodes_manager where mng_member_id=#{mng_member_id}")
	public MemberBCodesManagerVO findByMngMID(String mng_member_id);
	
	@Insert("insert into tbl_member_bcodes_manager ( "
			+ "mng_b_code, "
			+ "mng_member_id) values( "
			+ "#{mng_b_code,jdbcType=VARCHAR}, "
			+ "#{mng_member_id,jdbcType=VARCHAR}) ")
	public int insert(MemberBCodesManagerVO memberBCodesManagerVO);
	
	@Update("update tbl_member_bcodes_manager set( "
			+ "mng_b_code=#{mng_b_code,jdbcType=VARCHAR}, "
			+ "mng_member_id=#{mng_member_id,jdbcType=VARCHAR}) ")
	public int update(MemberBCodesManagerVO memberBCodesManagerVO);
	
	@Delete("delete from tbl_member_bcodes_manager where mng_b_code=#{mng_b_code}")
	public int delete(String mng_b_code);
}
