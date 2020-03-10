package com.biz.pet.controller;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.biz.pet.domain.RealEstateVO;
import com.biz.pet.domain.STourVO;
import com.biz.pet.domain.fwfsh.WaterFishingVO;
import com.biz.pet.domain.stourrest.json.STourVOJSON;
import com.biz.pet.service.RealEstService;
import com.biz.pet.service.TourService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequiredArgsConstructor
public class HomeController {
	private final TourService tourService;
	private final RealEstService rsService;
	
	//,produces = "text/json;charset=UTF-8"
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<WaterFishingVO> home(Locale locale, Model model) throws URISyntaxException {
		
		
		return tourService.getWaterFishingLoc();
	}
	
}
