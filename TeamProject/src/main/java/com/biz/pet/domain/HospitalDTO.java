package com.biz.pet.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HospitalDTO {

	private long h_seq;		//number
	private String h_name;		//nvarchar2(255 char)
	private String h_addr;		//nvarchar2(1000 char)
	private String h_tel;		//varchar2(15 byte)
	private String h_etc;		//nvarchar2(255 char)
	private String h_price;	//nvarchar2(1000 char)
	
}
