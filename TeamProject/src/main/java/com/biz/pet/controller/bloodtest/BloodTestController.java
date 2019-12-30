package com.biz.pet.controller.bloodtest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.pet.domain.bloodtest.BloodTestDTO;
import com.biz.pet.service.bloodtest.BloodTestService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/bloodtest")
@SessionAttributes("bldDTO")
@Controller
public class BloodTestController {
	@Autowired
	BloodTestService bldService;

	@ModelAttribute("bldDTO")
	public BloodTestDTO makeBldDTO() {
		BloodTestDTO bldDTO=new BloodTestDTO();
		return  bldDTO;
	}
	
	@RequestMapping(value = "/allList")
	public String allList(Model model) {
		List<BloodTestDTO> bldList = bldService.findAll();
		model.addAttribute("BLDLIST", bldList);
		return "bloodtest/allList";
	}
	
	@RequestMapping(value = "/findByNameAndValue",method=RequestMethod.POST)
	public String allList(@Valid @ModelAttribute("bldDTO") BloodTestDTO bldDTO, Model model) {
		log.debug("!!! blddTO in controller: "+bldDTO.toString());
		List<BloodTestDTO> bldList = bldService.findByNameAndValue(bldDTO);
		bldDTO=bldList.get(0);
		log.debug("!!! blddTO in controller: "+bldDTO.toString());
		model.addAttribute("bldDTO", bldDTO);
		return "bloodtest/findByNameAndValue";
	}
	
	@RequestMapping(value = "/view")
	public String view(String id,Model model) {
		BloodTestDTO bldDTO;
		try {
			long bld_seq=Long.valueOf(id);
			bldDTO=bldService.findBySeq(bld_seq);
			
			model.addAttribute("bldDTO", bldDTO);
		} catch (Exception e) {
			log.debug("exception occured!!!");
		}
		return "bloodtest/view";
	}

	@RequestMapping(value = "/insert",method=RequestMethod.GET)
	public String insert(Model model) {
		log.debug("insert get proceeded!!!");
		return "bloodtest/insert";
	}
	
	@RequestMapping(value = "/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute BloodTestDTO bldDTO, Model model) {
		log.debug("insert post proceeded!!!");
		int ret=bldService.insert(bldDTO);
		log.debug("insert to DB proceeded!!!");
		return "redirect:/bloodtest/allList";
	}

	@RequestMapping(value = "/update",method=RequestMethod.GET)
	public String update(String id,@ModelAttribute BloodTestDTO bldDTO, Model model) {
		log.debug("update get called!!!");
		long bld_seq=0;
		try {
			bld_seq=Long.valueOf(id);
		} catch (Exception e) {
			log.debug("!!! exception in update get!!!");
		}
		log.debug("!!! bld_seq: "+bld_seq);
		bldDTO=bldService.findBySeq(bld_seq);
		model.addAttribute("bldDTO", bldDTO);
		log.debug("!!!bldDTO: "+bldDTO.toString());
		return "bloodtest/update";
	}
	
	@RequestMapping(value = "/update",method=RequestMethod.POST)
	public String update(@ModelAttribute BloodTestDTO bldDTO, Model model) {
		log.debug("update post called!!!");
		int ret=bldService.update(bldDTO);
		return "redirect:/bloodtest/allList";
	}

	@RequestMapping(value = "/delete")
	public String delete(BloodTestDTO bldDTO, Model model, String id) {
		long bld_seq=0;
		try {
			bld_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int ret=bldService.delete(bld_seq);
		return "redirect:/bloodtest/allList";
	}

}
