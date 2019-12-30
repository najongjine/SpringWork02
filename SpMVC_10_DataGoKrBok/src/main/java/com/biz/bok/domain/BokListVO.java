package com.biz.bok.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BokListVO {
	/*private String servId;
	private String servNm;
	private String jurMnofNm;
	private String jurOrgNm;
	private String inqNum;
	private String servDgst;
	private String servDtlLink;
	private String svcfrstRegTs;*/
	
	private String inqNum;
	private String jurMnofNm;
	private String jurOrgNm;
	private String servDgst;
	private String servDtlLink;
	private String servId;
	private String servNm;
	private String svcfrstRegTs;

}
