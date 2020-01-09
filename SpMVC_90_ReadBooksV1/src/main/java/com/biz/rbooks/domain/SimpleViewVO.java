package com.biz.rbooks.domain;

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
public class SimpleViewVO {
	private String m_id;
	private String b_code;
	private String b_name;
	private String rb_date;
	private String rb_subject;
	private int tb_star;
}
