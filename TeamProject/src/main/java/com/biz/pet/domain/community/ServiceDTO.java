package com.biz.pet.domain.community;

import org.springframework.stereotype.Service;

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
public class ServiceDTO {
	
	private long se_seq; //	number
	private String se_auth; //	nvarchar2(20 char)
	private String se_date; //	varchar2(10 byte)
	private String se_subject; //	nvarchar2(125 char)
	private String se_text; //	nvarchar2(1000 char)
	
}
