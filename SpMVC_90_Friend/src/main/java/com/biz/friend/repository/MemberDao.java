package com.biz.friend.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.biz.friend.domain.MemberVO;

public interface MemberDao {
	
	@Select("select * from tbl_member where m_username=#{m_username}")
	public MemberVO findByUsername(String m_username);
	
	@Insert("INSERT INTO `emsdb`.`tbl_member` " + 
			"("
			+"`m_username`, " + 
			"`m_password`) " + 
			"VALUES " + 
			"("
			+"#{m_username  } , " + 
			"#{m_password  } ); " + 
			" ")
	public int insert(MemberVO memberVO);
}
