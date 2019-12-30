package com.biz.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.student.domain.StudentDTO;

@Service
public class StudentService {
	public List<StudentDTO> stdList(){
		List<StudentDTO> stdList=new ArrayList<StudentDTO>();
		StudentDTO stdDTO=new StudentDTO();
		stdDTO.setSt_num("0001");
		stdDTO.setSt_name("edfs");
		stdDTO.setSt_dept("comp");
		stdDTO.setSt_grade(1);
		stdDTO.setSt_tel("0001");
		stdList.add(stdDTO);
		
		stdDTO=new StudentDTO();
		stdDTO.setSt_num("0002");
		stdDTO.setSt_name("edfs2");
		stdDTO.setSt_dept("comp2");
		stdDTO.setSt_grade(2);
		stdDTO.setSt_tel("0002");
		stdList.add(stdDTO);
		
		stdDTO=new StudentDTO();
		stdDTO.setSt_num("0003");
		stdDTO.setSt_name("edfs3");
		stdDTO.setSt_dept("comp3");
		stdDTO.setSt_grade(3);
		stdDTO.setSt_tel("0003");
		stdList.add(stdDTO);
		
		return stdList;
	}
}
