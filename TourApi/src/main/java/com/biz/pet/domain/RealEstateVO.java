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
public class RealEstateVO {
	private String 거래금액;
	private String 건물면적;
	private String 건물주용도;
	private String 건축년도;
	private String 년;
	private String 대지면적;
	private String 법정동;
	private String 시군구;
	private String 용도지역;
	private String 월;
	private String 유형;
	private String 일;
	private String 지역코드;
}
