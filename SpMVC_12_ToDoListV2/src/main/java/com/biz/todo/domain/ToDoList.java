package com.biz.todo.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Alias("todoDTO")
/*
 * mybatis-context.xml에서 typeAliaspackage 속성을 사용할 경우
 * alias 이름이 자동으로 클래스 첫글자를 소문자로 변경한 형식으로 생성이 되는데
 * 클래스 이름이 너무 길거나, 이해하기 어려울 경우 별도의 별명을 붙일수 있다.
 * 이때 사용하는 annotation이 @alias이다.
 */
public class ToDoList {
	private long td_seq	;//NUMBER
	private String td_date	;//VARCHAR2(10 BYTE)
	private String td_time	;//VARCHAR2(8 BYTE)
	private String td_subject	;//NVARCHAR2(125 CHAR)
	private String td_text	;//NVARCHAR2(1000 CHAR)
	private String td_flag	;//VARCHAR2(1 BYTE)
	private String td_complete	;//VARCHAR2(1 BYTE)
	private String td_alarm	;//VARCHAR2(1 BYTE)
}
