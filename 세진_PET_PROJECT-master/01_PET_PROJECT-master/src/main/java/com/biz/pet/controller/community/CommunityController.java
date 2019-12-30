package com.biz.pet.controller.community;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.biz.pet.domain.community.PageDTO;
import com.biz.pet.domain.community.ReviewDTO;
import com.biz.pet.domain.community.ServiceDTO;
import com.biz.pet.service.community.PageService;
import com.biz.pet.service.community.ReviewService;
import com.biz.pet.service.community.ServiceService;

@RequestMapping(value="/community")
@Controller
public class CommunityController {
	
	@Autowired
	ReviewService rService;
	
	@Autowired
	ServiceService sService;
	
	@Autowired
	PageService pService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String list(Model model,
			@RequestParam(value="search", required = false,defaultValue = "") String re_subject,
			@RequestParam(value="currentPageNo", required = false,defaultValue = "1") int currentPageNo) {
		
		long totalCount = rService.totalCount(re_subject);
		PageDTO pageDTO = pService.getPagination(totalCount, currentPageNo); 
		
		List<ReviewDTO> reList = rService.findByRSubjectListAndPagiNation(re_subject, pageDTO);
		
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("search", re_subject);
		model.addAttribute("RELIST", reList);
	
		return "community/list";
	}
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String view(String id, @ModelAttribute ReviewDTO reDTO, Model model) {
		long re_seq = 0;
		try {
			re_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		reDTO = rService.getReview(re_seq);
		
		model.addAttribute("reDTO",reDTO);
		return "community/view";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insert(@ModelAttribute("reDTO") ReviewDTO reDTO, Model model) {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		reDTO.setRe_date(sd.format(date));

		model.addAttribute("reDTO",reDTO);
		
		return "community/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insert(@ModelAttribute("reDTO") ReviewDTO reDTO, Model model, SessionStatus sStatus) {
		int ret = rService.insert(reDTO);
	
		sStatus.setComplete();
		
		return "redirect:/community/list";
	}
		
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String update(String id, @ModelAttribute ReviewDTO reDTO, Model model) {
		long re_seq = 0;
		try {
			re_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		reDTO = rService.getReview(re_seq);
		
		model.addAttribute("reDTO", reDTO);
		return "community/insert";
	}

	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute ReviewDTO reDTO, Model model, SessionStatus sStatus) {

		int ret = rService.update(reDTO);
		
		sStatus.setComplete();
		return "redirect:/community/list";
	
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(@ModelAttribute ReviewDTO reDTO, long re_seq) {
		int ret = rService.delete(reDTO.getRe_seq());
		
		return "redirect:/community/list";
	}
	
	/* Service */
	@RequestMapping(value="/service/list",method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
	public String serviceList(Model model,
			@RequestParam(value="search", required = false,defaultValue = "") String se_subject,
			@RequestParam(value="currentPageNo", required = false,defaultValue = "1") int currentPageNo) {
		
		long totalCount = sService.totalCount(se_subject);
		PageDTO pageDTO = pService.getPagination(totalCount, currentPageNo);
		
		List<ServiceDTO> seList = sService.findBySSubjectListAndPagiNation(se_subject, pageDTO);
		
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("search", se_subject);
		model.addAttribute("SELIST", seList);
	
		return "community/service/list";
	}
	
	@RequestMapping(value="/service/view",method=RequestMethod.GET)
	public String serviceView(String id, @ModelAttribute ServiceDTO seDTO, Model model) {
		long se_seq = 0;
		try {
			se_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		seDTO = sService.getService(se_seq);
		
		model.addAttribute("seDTO",seDTO);
		return "community/service/view";
	}
	
	@RequestMapping(value="/service/insert",method=RequestMethod.GET)
	public String serviceInsert(@ModelAttribute("seDTO") ServiceDTO seDTO, Model model) {
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		seDTO.setSe_date(sd.format(date));

		model.addAttribute("seDTO",seDTO);
		
		return "community/service/insert";
	}
	
	@RequestMapping(value="/service/insert",method=RequestMethod.POST)
	public String servicInsert(@ModelAttribute("seDTO") ServiceDTO seDTO, Model model, SessionStatus sStatus) {
		int ret = sService.insert(seDTO);
	
		sStatus.setComplete();
		
		return "redirect:/community/service/list";
	}
		
	@RequestMapping(value="/service/update",method=RequestMethod.GET)
	public String serviceUpdate(String id, @ModelAttribute ServiceDTO seDTO, Model model) {
		long se_seq = 0;
		try {
			se_seq = Long.valueOf(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		seDTO = sService.getService(se_seq);
		
		model.addAttribute("seDTO", seDTO);
		return "community/service/insert";
	}

	@RequestMapping(value="/service/update",method=RequestMethod.POST)
	public String serviceUpdate(@ModelAttribute ServiceDTO seDTO, Model model, SessionStatus sStatus) {

		int ret = sService.update(seDTO);
		
		sStatus.setComplete();
		return "redirect:/community/service/list";
	
	}
	
	@RequestMapping(value="/service/delete",method=RequestMethod.GET)
	public String serviceDelete(@ModelAttribute ServiceDTO seDTO, long se_seq) {
		int ret = sService.delete(seDTO.getSe_seq());
		
		return "redirect:/community/service/list";
	}
	
}
