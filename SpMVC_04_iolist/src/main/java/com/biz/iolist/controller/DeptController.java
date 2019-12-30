package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.service.DeptService;

@RequestMapping(value="/dept")
@Controller
public class DeptController {
	@Autowired
	DeptService sService;
	/*
	 * class의 /dept 와 method의 /list를 묶어서
	 * /dept/list path로 req 했을때 list() method가 호출된다.
	 */
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(Model model) {
		/*
		 * Model(ui.Model) class와 같은 역활을 수행하는 Spring class
		 * 사용법이 조금 다른형식
		 * 여기에는 view와 객체를 동시에 담아서 dispatcher 에게 객체를 리턴해주는 형식으로 사용
		 * 
		 * Model은 객체만 담고
		 * view는 문자열을 return 하는 방식으로 사용
		 */
		ModelAndView mView=new ModelAndView();
		List<DeptDTO> deptList=sService.getAllList();
		mView.setViewName("/dept/list"); //return "/dept/list" 와 같은 역활
		// model.addAttribute("DEPLIST",deptlist) 와 같은 역활
		mView.addObject("DEPTLIST", deptList);
		return mView;
	}
}
