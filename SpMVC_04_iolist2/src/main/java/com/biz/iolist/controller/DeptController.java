package com.biz.iolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.iolist.domain.DeptDTO;
import com.biz.iolist.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/dept")
@Controller
public class DeptController {
	@Autowired
	DeptService dService;
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
		List<DeptDTO> deptList=dService.getAllList();
		mView.setViewName("/dept/list"); //return "/dept/list" 와 같은 역활
		// model.addAttribute("DEPLIST",deptlist) 와 같은 역활
		mView.addObject("DEPTLIST", deptList);
		return mView;
	}//end list
	
	/*
	 * 입력form을 보여주고 데이터를 입력 받도록 시작하는 절차
	 */
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String input(Model model) {
		
		return "dept/input";
	}
	
	/*
	 * 입력 form에서 데이터를 입력하고 전송을 클릭하면 데이터를 가지고 호출된 method
	 */
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String input(DeptDTO deptDTO, Model model) {
		log.debug("거래처정보"+deptDTO.toString());
		int ret=dService.insert(deptDTO);
		
		/*
		 * redirect: 문자열로 시작되는 return
		 * view(*jsp, /dept.list.jsp)를 호출하라는것이 아니고
		 * http://localhost:8080/context/dept/list 명령을 실행하라
		 * 메뉴에서 /dept/list 주소를 클릭하라
		 * 브라우저 주소창에 ~~/dept/list를 입력하고 enter
		 */
		return "redirect:/dept/list";
	}
	
	@RequestMapping(value = "/view", method=RequestMethod.GET)
	public String view(String d_code, Model model) {
		log.debug("거래처코드: "+d_code);
		DeptDTO deptDTO=dService.findByDCode(d_code);
		model.addAttribute("DEPT_DTO",deptDTO);
		return null;
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String delete(String id,Model model) {
		int let=dService.delete(id);
		return "redirect:/dept/list";
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String update(String id,Model model) {
		log.debug("update get called!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		DeptDTO dDTO=dService.findByDCode(id);
		model.addAttribute("DI", dDTO);
		return "dept/input";
	}
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(DeptDTO deptDTO,Model model) {
		log.debug("update post called!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		int ret=dService.update(deptDTO);
		//DeptDTO dDTO=dService.findByDCode(d_code);
		//model.addAttribute("DI", dDTO);
		return "redirect:/dept/list";
	}
}
