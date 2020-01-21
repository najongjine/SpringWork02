package com.biz.todo.domain;

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
public class TestVO {
	private long t_seq;//	number
	private String t_title;//	nvarchar2(150 char)
	private String 	t_content;//	nvarchar2(2000 char)
}
