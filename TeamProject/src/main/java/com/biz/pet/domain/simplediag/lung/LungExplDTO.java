package com.biz.pet.domain.simplediag.lung;

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
public class LungExplDTO {
	private long lung_e_seq	;//number
	private String lung_e_code	;//nvarchar2(1000 char)
	private String lung_e_expl	;//nvarchar2(1000 char)
	private String lung_e_name	;//nvarchar2(1000 char)
}
