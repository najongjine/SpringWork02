package com.biz.rbooks.repository;

import org.apache.ibatis.jdbc.SQL;

public class ReadBookSQL {
	public String insertSQL() {
		return new SQL() {
			{
				INSERT_INTO("tbl_read_book");
				INTO_COLUMNS("RB_SEQ");
				INTO_COLUMNS("RB_BCODE");
				INTO_COLUMNS("RB_DATE");
				INTO_COLUMNS("RB_STIME");
				INTO_COLUMNS("RB_RTIME");
				INTO_COLUMNS("RB_SUBJECT");
				INTO_COLUMNS("RB_TEXT");
				INTO_COLUMNS("RB_STAR");
				INTO_COLUMNS("RB_MID");
				
				INTO_VALUES("seq_read_book.nextval");
				INTO_VALUES("#{rb_bcode,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_date,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_stime,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_rtime,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_subject,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_text,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_star,jdbcType=VARCHAR}");
				INTO_VALUES("#{rb_mid,jdbcType=VARCHAR}");
			}
		}.toString();
	}
	public String updateSQL() {
		return new SQL() {
			{
				UPDATE("tbl_read_book");
				WHERE("RB_SEQ =#{rb_seq,jdbcType=VARCHAR}");
				SET("RB_BCODE= #{rb_bcode,jdbcType=VARCHAR}");
				SET("RB_DATE =#{rb_date,jdbcType=VARCHAR}");
				SET("RB_STIME =#{rb_stime,jdbcType=VARCHAR}");
				SET("RB_RTIME =#{rb_rtime,jdbcType=VARCHAR}");
				SET("RB_SUBJECT= #{rb_subject,jdbcType=VARCHAR}");
				SET("RB_TEXT =#{rb_text,jdbcType=VARCHAR}");
				SET("RB_STAR= #{rb_star,jdbcType=VARCHAR}");
			}
		}.toString();
	}
}
