package com.biz.pet.controller.simplediag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.pet.domain.simplediag.lung.LungDTO;
import com.biz.pet.persistence.simplediag.lung.LungDao;
import com.biz.pet.service.simplediag.lung.LungService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/simplediag")
@SessionAttributes("LungDTO")
@Controller
public class SimpleDiagController {
	@Autowired
	LungService lungService;

	@ModelAttribute("LungDTO")
	public LungDTO makeLungDTO() {
		LungDTO lungDTO=new LungDTO();
		return lungDTO;
	}
	
	@RequestMapping(value = "/main")
	public String simplediagMain(Model model) {
		return "simplediag/main";
	}
	
	@RequestMapping(value = "/lung")
	public String lung(Model model) {
		List<LungDTO> lungList=lungService.findAllList();
		model.addAttribute("LUNG_LIST", lungList);
		log.debug("!!!lunglist(in controller): "+lungList.toString());
		return "simplediag/lung/lung";
	}
}
