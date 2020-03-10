package com.biz.pet.domain.fwfsh;

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
public class WaterFishingVO {
/*
 * <addr1>Hoban-ro, Andong-si, Gyeongsangbuk-do</addr1>
<areacode>35</areacode>
<cat1>A03</cat1>
<cat2>A0303</cat2>
<cat3>A03030500</cat3>
<contentid>1891010</contentid>
<contenttypeid>75</contenttypeid>
<createdtime>20140204170316</createdtime>
 */
	private String addr1;
	private String areacode;
	private String cat1;
	private String cat2;
	private String cat3;
	private String contentid;
	private String contenttypeid;
	private String createdtime;
	//private String firstimage;
	//private String firstimage2;
	private String mapx;
	private String mapy;
	private String masterid;
	private String mlevel;
	private String modifiedtime;
	private String readcount;
	private String sigungucode;
	private String tel;
	private String title;
	private String zipcode;
	
}
