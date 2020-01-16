package com.biz.rbooks.domain;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * mybatis-context.xml 에서 typeAliasPackage를 설정해두면 자동으로 VO 클래스를 준비하는데
 * 이름을 클래스의 첫글자만 소문자로 바꾸는 방식으로 설정을 한다.
 * 
 * 그 자동으로 설정되는 alias를 임의로 변경하고자 할때 사용하는 Annotation
 */
@Alias("rBookVO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReadBookVO {
	private String rb_seq;
	private String rb_mid;
	private String rb_bcode;
	private String rb_bname;
	private String rb_date;
	private String rb_stime;
	private float rb_rtime;
	private String rb_subject;
	private String rb_text;
	private int rb_star;
}
