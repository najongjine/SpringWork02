package com.biz.pet.domain.bloodtest;

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
public class BloodTestDTO {
	private long bld_seq	;//number
	private String bld_name;//	nvarchar2(50 char)
	private int bld_normalmin	;//number
	private int bld_normalmax	;//number
	private String bld_overnormal	;//nvarchar2(1000 char)
	private String bld_belownormal	;//nvarchar2(1000 char)
	private String bld_name_kor;
	private int value;
	private String currentStatus;
}
