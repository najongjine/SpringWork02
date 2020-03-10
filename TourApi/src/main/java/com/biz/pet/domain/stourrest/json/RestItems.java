package com.biz.pet.domain.stourrest.json;

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
@NoArgsConstructor()
@ToString
@Builder
public class RestItems {
	//public RestItem item;
	private List<STourVOJSON> item;
}
