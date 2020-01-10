package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

public class MemberSQL {
	public String insertSQL() {
		return new SQL() {
			{
				INSERT_INTO("tbl_member");
				INTO_COLUMNS("M_ID");
				INTO_COLUMNS("M_PASSWORD");
				INTO_COLUMNS("M_LOGIN_DATE");
				INTO_COLUMNS("M_REM");

				INTO_VALUES("#{m_id,jdbcType=VARCHAR}");
				INTO_VALUES("#{m_password,jdbcType=VARCHAR}");
				INTO_VALUES("#{m_login_date,jdbcType=VARCHAR}");
				INTO_VALUES("#{m_rem,jdbcType=VARCHAR}");
			}
		}.toString();
	}
	public String updateSQL() {
		return new SQL() {
			{
				UPDATE("tbl_member");
				WHERE("m_id=#{m_id}");
				SET("M_PASSWORD=#{m_password,jdbcType=VARCHAR}");
				SET("m_login_date=#{m_login_date,jdbcType=VARCHAR}");
				SET("m_rem=#{m_rem,jdbcType=VARCHAR}");
			}
		}.toString();
	}
}
