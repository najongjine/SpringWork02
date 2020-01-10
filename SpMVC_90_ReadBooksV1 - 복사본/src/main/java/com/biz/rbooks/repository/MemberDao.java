package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.MemberBCodesManagerVO;
import com.biz.rbooks.domain.MemberVO;

public interface MemberDao {
	@Select("select * from tbl_member")
	@Results(
			value= {
				@Result(property="m_id", column = "m_id"),
				@Result(property = "memberBCodesManagerList", column = "m_id", javaType = List.class, 
				many=@Many(select = "findMemBCManagerByMID"))
				}
			)
	public List<MemberVO> selectAll();
	
	@Select("select * from tbl_member_bcodes_manager where mng_member_id=#{m_id}")
	public List<MemberBCodesManagerVO> findMemBCManagerByMID(String m_id);
	
	@Select("select * from tbl_member where M_ID=#{m_id}")
	@Results(
			value= {
				@Result(property="m_id", column = "m_id"),
				@Result(property = "memberBCodesManagerList", column = "m_id", javaType = List.class, 
				many=@Many(select = "findMemBCManagerByMID"))
				}
			)
	public MemberVO findByM_ID(String m_id);
	
	@UpdateProvider(type = MemberSQL.class,method = "updateSQL")
	public int update(MemberVO memberVO);
	
	@InsertProvider(type = MemberSQL.class,method = "insertSQL")
	public int insert(MemberVO memberVO);
	
	@Delete("delete from tbl_member where m_id=#{m_id}")
	public int delete(String m_id);
}
