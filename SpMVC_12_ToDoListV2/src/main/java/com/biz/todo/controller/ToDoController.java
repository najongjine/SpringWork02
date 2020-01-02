package com.biz.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.todo.common.ToDoAnn;
import com.biz.todo.domain.ToDoList;
import com.biz.todo.service.ToDoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ToDoController {
	@Autowired
	@Qualifier("todoV3")
	ToDoService toService;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(Model model) {
		/*
		 * 팀 단위에서 controller 개발자와 service개발자가 다를경우
		 * service는 interface가 정의되어 있기 때문에
		 * 아직 기능은 구현되지 않았어도 controller개발자는 당연히 Service의 method를 호출하면
		 * 결과가 리턴될 것이다라는것을 알고
		 * 나머지 코드를 구현할수 있게된다.
		 */
		List<ToDoList> todoList=toService.selectAll();
		model.addAttribute("todoList", todoList);
		return "home";
	}
	
	@RequestMapping(value = "/list",method=RequestMethod.POST)
	public String insert(@ModelAttribute ToDoList toDoList, Model model) {
		int ret=toService.insert(toDoList);
		if(ret<1) {
			model.addAttribute("INSERT ERROR", "Not_INSERT");
		}
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/complete", method=RequestMethod.GET)
	public String complete(@RequestParam("td_seq") String strSeq,@RequestParam("td_complete") String td_complete) {
		toService.complete(strSeq);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/alarm", method=RequestMethod.GET)
	public String alarm(@RequestParam("td_seq") String strSeq,@RequestParam("td_alarm") String td_alarm) {
		toService.alarm(strSeq);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/delete",method=RequestMethod.GET)
	public String delete(@RequestParam("td_seq") String strSeq) {
		long td_seq=-1;
		try {
			td_seq=Long.valueOf(strSeq);
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("삭제오류");
		}
		
		toService.delete(td_seq);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String update(@RequestParam("td_seq") String strSeq, Model model) {
		long td_seq=-1;
		try {
			td_seq=Long.valueOf(strSeq);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ToDoList toDTO=toService.findBySeq(td_seq);
		model.addAttribute("todoDTO", toDTO);
		
		List<ToDoList> tdList=toService.selectAll();
		model.addAttribute("todoList", tdList);
		return "home";
	}
	
	@RequestMapping(value = "update",method=RequestMethod.POST)
	public String update(ToDoList toList,Model model) {
		toService.update(toList);
		return "redirect:/list";
	}
}
