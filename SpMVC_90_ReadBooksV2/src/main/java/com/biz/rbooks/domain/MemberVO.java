package com.biz.rbooks.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberVO {
	@NotNull
	private String m_id;//	varchar2(20 byte)
	
	@NotNull
	private String m_password;//	nvarchar2(125 char)
	
	private String m_login_date;//	varchar2(10 byte)
	private String m_rem;//	nvarchar2(125 char)
	
	List<MemberBCodesManagerVO> memberBCodesManagerList=new ArrayList<MemberBCodesManagerVO>();
}
