package com.biz.pet.domain.stourrest.json;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("code")
	public String code;
	
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("rnum")
	public String rnum;
}
