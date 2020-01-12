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
public class MemberNReadBookVO {
	private String m_id;//	varchar2(20 byte)
	private String m_password;//	nvarchar2(125 char)
	private String m_login_date;//	varchar2(10 byte)
	private String m_rem;//	nvarchar2(125 char)
	private long rb_seq;//	number
	private String rb_mid;//	varchar2(20 byte)
	private String rb_bcode;//	varchar2(20 byte)
	private String rb_date;//	varchar2(10 byte)
	private String rb_stime;//	varchar2(10 byte)
	private int rb_rtime;//	number(10,3)
	private String rb_subject;//	nvarchar2(20 char)
	private String rb_text;//	nvarchar2(400 char)
	private int rb_star;//	number
}
