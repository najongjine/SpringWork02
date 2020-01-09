package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

import com.biz.rbooks.domain.MemberVO;

public interface MemberDao {
	@Select("select * from tbl_member")
	public List<MemberVO> selectAll();
	
	@Select("select * from tbl_member where M_ID=#{m_id}")
	public MemberVO findByM_ID(String m_id);
	
	@UpdateProvider(type = MemberSQL.class,method = "updateSQL")
	public int update(MemberVO memberVO);
	
	@InsertProvider(type = MemberSQL.class,method = "insertSQL")
	public int insert(MemberVO memberVO);
	
	@Delete("delete from tbl_member where m_id=#{m_id}")
	public int delete(String m_id);
}
