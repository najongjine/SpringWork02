package com.biz.pet.controller.simplediag.lung;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.biz.pet.domain.najongjinutil.JongPageDTO;
import com.biz.pet.domain.simplediag.lung.LungDTO;
import com.biz.pet.domain.simplediag.lung.LungExplDTO;
import com.biz.pet.service.najongjinUtil.JongFileService;
import com.biz.pet.service.simplediag.lung.LungExplService;
import com.biz.pet.service.simplediag.lung.LungService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/simplediag/lung")
@Controller
public class LungController {
	@Autowired
	LungService lungService;
	@Autowired
	LungExplService leService;
	@Autowired
	JongFileService fileService;

	@RequestMapping(value = "/list")
	public String lung(Model model,String cat, String search, @RequestParam(value = "currentPageNo", required = false,
			defaultValue = "1") long currentPageNo) {
		List<LungDTO> lungList=lungService.findAllList();
		List<LungDTO> perPageList=new ArrayList<LungDTO>();
		
		JongPageDTO pageDTO=lungService.getPage(cat, search, currentPageNo);
		//1*10.   1~10.    0~9
		int endItem=(int) (pageDTO.getCurrentPageNo()*pageDTO.getListPerPage());
		int startItem=(int) ((pageDTO.getCurrentPageNo()-1)*pageDTO.getListPerPage());
		try {
			perPageList.removeAll(perPageList);
			for(int i=startItem;i<endItem;i++) {
				LungDTO lungDTO=lungList.get(i);
				perPageList.add(lungDTO);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		model.addAttribute("PAGE", pageDTO);
		model.addAttribute("LUNG_LIST", perPageList);
		
		return "simplediag/lung/lung";
	}
	
	@RequestMapping(value = "/alter",method=RequestMethod.GET)
	public String alter(@ModelAttribute LungDTO lungDTO, @ModelAttribute LungExplDTO leDTO,
			Model model, String strSeq) {
		long lung_seq=-1;
		List<LungExplDTO> leList=null;
		
		try {
			lung_seq=Long.valueOf(strSeq);
			log.debug("!!!alter get lung seq: "+lung_seq);
			lungDTO=lungService.findBySeq(lung_seq);
			leList=lungDTO.getExplList();
		} catch (Exception e) {
			lung_seq=-1;
		}
		
		model.addAttribute("lungDTO",lungDTO);
		model.addAttribute("leList", leList);
		return "simplediag/lung/alter";
	}
	
	@RequestMapping(value = "/alter",method=RequestMethod.POST)
	public String alter(@ModelAttribute("lungDTO") LungDTO lungDTO,// , @ModelAttribute LungExplDTO leDTO,
			String[] currentStrExpl,Model model , String[] newStrExpl,String lung_e_code,
			String lung_e_name, @RequestParam(value="u_file", required = false) MultipartFile u_file) {
		
		for(String s:newStrExpl) {
			log.debug("!!! nrwStr: "+s);
		}
		int ret=0;
		if(!u_file.isEmpty()) {
			//update 할때 이미 upload된 파일이 있으면 기존의 파일을 삭제하고 새로운 파일을 업로드 해야함으로
			//p_file 변수를 검사하여 값이 있으면 파일을 삭제하자.
			if(lungDTO.getLung_imgurl()!=null) {
				fileService.fileDelete(lungDTO.getLung_imgurl());
			}
			String upFileName=fileService.fileUp(u_file);
			if(upFileName!= null) {
				/*
				 * 정상적으로 저장이 완료되면 파일이름을 DTO에 p_file 변수에 저장을 한다.
				 */
				lungDTO.setLung_imgurl(upFileName);
			}
			
		}
		if(lungService.findBySeq(lungDTO.getLung_seq())==null) {
			ret=lungService.insert(lungDTO);
		}
		
		if(lungService.findBySeq(lungDTO.getLung_seq())!=null) {
			ret=lungService.update(lungDTO);
		}
		ret=leService.update(currentStrExpl,lung_e_code);
		 ret=leService.insert(newStrExpl,lung_e_code,lung_e_name);
		return "redirect:/simplediag/lung/list";
	}
	
	@RequestMapping(value = "/deleteAll")
	public String delete(@RequestParam("lung_seq") String strSeq) {
		long lung_seq=Long.valueOf(strSeq);
		imgDelete(lung_seq);
		lungService.delete(lung_seq);
		return "redirect:/simplediag/lung/list";
	}
	
	
	@RequestMapping(value = "imgDelete",method=RequestMethod.GET)
	public String imgDelete(long lung_seq) {
		if(lung_seq<1) return null;
		LungDTO lungDTO=lungService.findBySeq(lung_seq);
		if(lungDTO.getLung_imgurl()!=null && !lungDTO.getLung_imgurl().isEmpty()) {
			fileService.fileDelete(lungDTO.getLung_imgurl());
			lungDTO.setLung_imgurl(null);
			lungService.update(lungDTO);
		}
		return "redirect:/plist";
	}
}
