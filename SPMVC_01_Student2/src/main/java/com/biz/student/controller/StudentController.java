package com.biz.student.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.student.domain.StudentDTO;
import com.biz.student.service.AnnService;
import com.biz.student.service.HomeService;
import com.biz.student.service.StudentService;

/*
 * Tomcat, Spring container에 이 클래스의 List를 추가하고
 * req 요청에 대비하라
 */
@Controller
public class StudentController {
	//@Autowired //생성자 알아서 singleton으로 만들어줌. @Service 필요함.
	@Inject
	StudentService sService;
	@Autowired
	HomeService hService;
	@Autowired
	AnnService aService;
	
	public StudentController() {
		sService=new StudentService();
		
	}
	/*
	 * form에서 전달받은 데이터는 String.
	 * int 형 자료는 spring이 자동으로 형변환 함.
	 */
	@RequestMapping(value = "input",method=RequestMethod.GET)
	public String input() {
		// /WEB-INF/views/student/input.jsp 파일을 열어서 browser로 전송하라!
		return "student/input"; //value에 있는 문자열이 자동으로 포함됨
	}
	@RequestMapping(value = "input",method=RequestMethod.POST)
	public String input(StudentDTO stDTO,Model model) {
		// /WEB-INF/views/student/input.jsp 파일을 열어서 browser로 전송하라!
		System.out.println(stDTO.toString());
		model.addAttribute("stDTO",stDTO);//"spring변수", 자바객체
		return "student/view"; //value에 있는 문자열이 자동으로 포함됨
	}
	@RequestMapping(value = "search",method=RequestMethod.GET)
	public String search() {
		sService.viewStudent();
		hService.viewHome();
		aService.viewAnn();
		return "student/search";
	}
	@RequestMapping(value = "view",method = RequestMethod.GET)
	public String view() {
		return "student/view";
	}
	@RequestMapping(value = "list",method = RequestMethod.GET)
	public String view(Model model) {
		List<StudentDTO> stdList=sService.stdList();
		model.addAttribute("stdList",stdList);
		return "student/viewList";
	}
}
