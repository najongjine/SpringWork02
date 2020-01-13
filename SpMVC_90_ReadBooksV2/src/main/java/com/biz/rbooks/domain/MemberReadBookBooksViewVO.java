package com.biz.rbooks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

/*
 * tbl_member+tbl_read_book+tbl_books view
 */
public class MemberReadBookBooksViewVO {
	private long rb_seq; 
	private String rb_mid; 
	private String rb_bcode; 
	private String rb_date; 
	private String rb_stime; 
	private int rb_rtime; 
	private String rb_subject; 
	private String rb_text; 
	private int rb_star;
	private String b_name; 
	private String b_auther; 
	private String b_comp; 
	private String b_year; 
	private int b_iprice;
	private String m_login_date;
	private String m_rem;
}
