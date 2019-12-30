package com.biz.pet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.pet.domain.HospitalDTO;
import com.biz.pet.domain.HospitalPageDTO;
import com.biz.pet.service.HospitalService;
import com.biz.pet.service.HospitalPageService;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes("hDTO")
@Slf4j
@RequestMapping(value="/hospital")
@Controller
public class HospitalController {
	
	@Autowired
	HospitalService hService;
	
	@Autowired
	HospitalPageService pService;
	
	@ModelAttribute("hDTO")
	public HospitalDTO makeHDTO() {
		
		HospitalDTO hDTO = new HospitalDTO();
		return hDTO;
	}
	
	@RequestMapping(value="/hlist", method=RequestMethod.GET)
	public String hlist(@RequestParam(value="currentPageNo", required = false, defaultValue = "1") int currentPageNo, String search, Model model) {
		
		long totalCount = hService.totalCount();
		HospitalPageDTO pageDTO = pService.getPagination(totalCount, currentPageNo);
		List<HospitalDTO> hList = hService.selectPagination(pageDTO);
		
		model.addAttribute(pageDTO);
		model.addAttribute("H_LIST", hList);
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute("hDTO") HospitalDTO hDTO, Model model) {
		
		
		model.addAttribute("hDTO", hDTO);
		return null;
		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute("hDTO") HospitalDTO hDTO, String search) {
		
		int ret = hService.insert(hDTO);
		
		return "redirect:/hospital/hlist";
		
	}
	
	@RequestMapping(value="/viewdetail", method=RequestMethod.GET)
	public String viewdetail(@RequestParam("id") String id, @ModelAttribute HospitalDTO hDTO, Model model) {
		
		
		long h_seq = 0;
		
		try {
			h_seq = Long.valueOf(id);
		} catch (Exception e) {
		}
		hDTO = hService.getList(h_seq);
		model.addAttribute("hDTO", hDTO);
		
		return null;
		
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String update(String id, @ModelAttribute HospitalDTO hDTO, Model model) {
		
		long h_seq = 0;
		try {
			h_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		hDTO = hService.findBySeq(h_seq);
		model.addAttribute("hDTO", hDTO);
		
		return "hospital/insert";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String update(HospitalDTO hDTO, Model model) {
		int ret = hService.update(hDTO);
		
		return "redirect:/hospital/hlist";
	}
	

	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@ModelAttribute HospitalDTO hDTO) {
		
		int ret = hService.delete(hDTO.getH_seq());
		
		return "redirect:/hospital/hlist";
	}
}
