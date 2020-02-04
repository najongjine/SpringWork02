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
import com.biz.pet.service.RealEstService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequiredArgsConstructor
public class HomeController {
	private final RealEstService realEstService;
	
	//,produces = "text/json;charset=UTF-8"
	@ResponseBody
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<RealEstateVO> home(Locale locale, Model model) throws URISyntaxException {
		
		
		return realEstService.getRestVoList("201606");
	}
	
}
