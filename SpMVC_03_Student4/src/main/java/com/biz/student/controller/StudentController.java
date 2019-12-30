package com.biz.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.domain.StudentDTO;
import com.biz.student.domain.StudentVO;
import com.biz.student.service.StudentService;

@RequestMapping(value="/student")
@Controller
public class StudentController {
	/*
	 * 이미 생성(초기화) 되어서 컨테이너에 보관중인 sdservice의 인스턴스를 가져다가
	 * sServide를 사용할수 있도록 만들어주는 역활
	 */
	@Autowired
	StudentService sService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("BODY","STUDENT-LIST");
		List<StudentDTO> stdList=sService.getStdList();
		model.addAttribute("STDLIST",stdList);
		//return null;
		return "home";
	}
	@RequestMapping(value="/list/vo",method = RequestMethod.GET)
	public String list(Model model,String s) {
		model.addAttribute("BODY","STUDENT-LIST");
		List<StudentVO> stdList=sService.getSedAllList();
		model.addAttribute("STDLIST",stdList);
		//return null;
		return "home";
	}
	
}
