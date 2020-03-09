package com.biz.pet.domain;

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
public class STourVO {
	//<code>1</code><name>강남구</name><rnum>1</rnum>
	private String code;
	private String name;
	private String rnum;
}
