package com.biz.pet.domain.community;

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
public class ReviewDTO {
	
	private long re_seq; 	//	number
	private String re_auth; 	//	nvarchar2(20 char)
	private String re_date; 	//	varchar2(10 byte)
	private String re_subject; 	//	nvarchar2(125 char)
	private String re_text; 	//	nvarchar2(1000 char)

}
