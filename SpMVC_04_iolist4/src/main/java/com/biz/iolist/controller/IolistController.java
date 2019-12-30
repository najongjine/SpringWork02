package com.biz.iolist.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.iolist.domain.IolistDTO;
import com.biz.iolist.domain.IolistVO;
import com.biz.iolist.service.IolistService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/iolist")
@Controller
public class IolistController {
	@Autowired
	IolistService ioService;
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String ioHome(Model model) {
		List<IolistVO> iolistVO=ioService.viewAllList();
		model.addAttribute("IOLIST",iolistVO);
		return "iolist/list";
	}
	
	/*@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String viewAll(Model model) {
		List<IolistVO> iolistVO=ioService.viewFindAll();
		model.addAttribute("IOLISTVO",iolistVO);
		return "iolist/list";
	}*/
	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String list(Model model) {
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String curDate=sd.format(date);
		IolistDTO ioDTO=IolistDTO.builder().io_date(curDate).io_price(1000).build();
		model.addAttribute("IO_DTO", ioDTO);
		return "iolist/input";
	}
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String list(IolistDTO ioDTO, Model model) {
		int ret=ioService.insert(ioDTO);
		return "redirect:/iolist/list";
	}
	
	/*
	 * tbl_iolist seq 는 숫자인데 일단 seq 조회를 하기위한 쿼리값인 id는 문자열로 받는다
	 * 혹시 id값이 전송되지 않아서 발생할수 있는 400 오류를 방지하기 위함
	 * */
	@RequestMapping(value = "/view",method=RequestMethod.GET)
	public String view(String id, Model model) {
		long io_seq=0;
		try {
			io_seq=Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		IolistVO ioDTO=ioService.findBySeq(io_seq);
		model.addAttribute("IO_DTO", ioDTO);
		return "iolist/view";
	}
	/*@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert() {
		return "iolist/insert";
	}
	@RequestMapping(value = "/insert")
	public String insert(IolistDTO iolistDTO, Model model) {
		ioService.insert(iolistDTO);
		return "iolist/list";
	}*/
	
	@RequestMapping(value = "/update")
	public String update(IolistDTO iolistDTO, Model model) {
		ioService.update(iolistDTO);
		return "iolist/list";
	}
	@RequestMapping(value = "/delete")
	public String delete(IolistDTO iolistDTO, Model model) {
		ioService.delete(iolistDTO.getIo_seq());
		return "iolist/list"; 
	}
}
