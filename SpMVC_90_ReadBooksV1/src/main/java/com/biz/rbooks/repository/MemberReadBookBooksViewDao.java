package com.biz.rbooks.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.biz.rbooks.domain.MemberReadBookBooksViewVO;

public interface MemberReadBookBooksViewDao {
	@Select("select DISTINCT(rb_seq) " + 
			"RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM " + 
			"from tbl_member,TBL_BOOKS,TBL_READ_BOOK " + 
			"where m_id=#{m_id} and B_CODE=RB_BCODE and RB_MID=m_id " + 
			"group by RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR,B_NAME, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM")
	public List<MemberReadBookBooksViewVO> findAllByM_Id(String m_id);
	
	@Select("select DISTINCT(rb_seq) " + 
			"RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM " + 
			"from tbl_member,TBL_BOOKS,TBL_READ_BOOK " + 
			"where m_id=#{_m_id} and B_CODE=RB_BCODE and RB_MID=m_id " + 
			"and rb_seq=#{rb_seq} " + 
			"group by RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR,B_NAME, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM ")
	public MemberReadBookBooksViewVO findDetailByM_IdNRb_Seq(@Param("_m_id")String _m_id,
			@Param("rb_seq") long rb_seq);
	
	@Select("select DISTINCT(rb_seq) " + 
			"RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM " + 
			"from tbl_member,TBL_BOOKS,TBL_READ_BOOK " + 
			"where m_id=#{_m_id} and B_CODE=RB_BCODE and RB_MID=m_id " + 
			"and b_name like '%' || #{inputStr} || '%' " + 
			"group by RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR,B_NAME, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM ")
	public List<MemberReadBookBooksViewVO> findAllByM_IdNBName(@Param("_m_id")String _m_id,
			@Param("inputStr") String inputStr);
	
	@Select("select DISTINCT(rb_seq) " + 
			"RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM " + 
			"from tbl_member,TBL_BOOKS,TBL_READ_BOOK " + 
			"where m_id=#{_m_id} and B_CODE=RB_BCODE and RB_MID=m_id " + 
			"and RB_BCODE=#{inputStr} " + 
			"group by RB_SEQ, RB_MID, RB_BCODE, RB_DATE, RB_STIME, RB_RTIME, RB_SUBJECT, RB_TEXT, RB_STAR,B_NAME, B_NAME, B_AUTHER, B_COMP, B_YEAR, B_IPRICE, " + 
			"M_LOGIN_DATE,M_REM ")
	public List<MemberReadBookBooksViewVO> findAllByM_IdNBCode(@Param("_m_id")String _m_id,
			@Param("inputStr") String inputStr);
}
