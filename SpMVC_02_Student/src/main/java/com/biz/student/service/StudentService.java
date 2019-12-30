package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

//@service spring frame container에 등록될 bean이다
@Slf4j
@Service
public class StudentService {
	public List<String> getList(){
		List<String> strList=new ArrayList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		strList.add("e");
		strList.add("f");
		return strList;
	}
}
