package com.biz.pet.domain.stourrest.json;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@ToString
@Builder
public class RestItem {
	public List<STourVOJSON> sList;
}
