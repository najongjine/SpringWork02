package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;

@Service
public class StudentService {
	public List<StudentDTO> getStdList(){
		List<StudentDTO> stdList=new ArrayList<StudentDTO>();
		StudentDTO stDTO;
		stDTO=StudentDTO.builder().st_addr("aaa").st_dept("aaadpt").st_grade(1).st_name("aaaa")
				.st_num("111").st_pro("dfd").st_tel("1111111111").build();
		stdList.add(stDTO);

		stDTO=StudentDTO.builder().st_addr("aaa2").st_dept("aaadpt2").st_grade(1).st_name("aaaa2")
				.st_num("112").st_pro("dfd").st_tel("1111111112").build();
		stdList.add(stDTO);

		stDTO=StudentDTO.builder().st_addr("aaa3").st_dept("aaadpt3").st_grade(1).st_name("aaaa3")
				.st_num("113").st_pro("dfd").st_tel("1111111113").build();
		stdList.add(stDTO);

		stDTO=StudentDTO.builder().st_addr("aaa4").st_dept("aaadpt4").st_grade(1).st_name("aaaa4")
				.st_num("114").st_pro("dfd").st_tel("1111111114").build();
		stdList.add(stDTO);
		//return stdList;
		return null;
	}
}
