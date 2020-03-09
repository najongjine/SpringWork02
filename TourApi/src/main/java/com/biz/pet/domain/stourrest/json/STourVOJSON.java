package com.biz.pet.domain.stourrest.json;

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
public class STourVOJSON {
	//<code>1</code><name>강남구</name><rnum>1</rnum>
	public String START_OBJECT;
	public String code;
	public String name;
	public String rnum;
}
