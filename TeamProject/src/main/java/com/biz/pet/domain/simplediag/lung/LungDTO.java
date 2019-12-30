package com.biz.pet.domain.simplediag.lung;

import java.util.ArrayList;
import java.util.List;

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
public class LungDTO {
	private long lung_seq	;//number
	private String lung_imgurl	;//nvarchar2(1000 char)
	private String lung_name	;//nvarchar2(1000 char)
	private String lung_explcode	;//nvarchar2(1000 char)
	private List<LungExplDTO> explList=new ArrayList<LungExplDTO>();
}
