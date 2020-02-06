package com.biz.todo.domain;

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
public class TestVO {
	String test1="1";
	String test2="2";
	List<String> testList=new ArrayList<String>();
	{
		testList.add("3");
		testList.add("4");
		testList.add("5");
	}
}
