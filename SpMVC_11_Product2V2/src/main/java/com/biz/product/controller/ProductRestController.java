package com.biz.product.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.biz.product.domain.ProductDTO;
import com.biz.product.service.ProductSerivce;

import lombok.extern.slf4j.Slf4j;

/*
 * 지금부터 이 컨트롤러는 rest full 서비스를 response할 친구다 라는 선언.
 * 이 컨트롤러에선 모든 method는 절대 view를 리턴할수 없다.
 * Model, ModelAndView 클래스를 사용하지 않아도 된다.
 */
@Slf4j
@RequestMapping(value = "/rest")
@RestController
public class ProductRestController {
	@Autowired
	ProductSerivce pService;
	
	@RequestMapping(value = "/getProduct",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ProductDTO getProduct(String p_code) {
		ProductDTO proDTO=pService.findByPCode(p_code);
		return proDTO;
	}
	
	@RequestMapping(value = "/getString",method=RequestMethod.GET, produces = "text/json;charset=UTF-8")
	//query로 보내는 변수명
	//required & defaulot를 빼면 400오류를 보냄
	//responsebody를 사용할때는 produces를 사용해야한다.
	public String getString(@RequestParam(value="str", required = false, defaultValue = "없음") String myStr) {
		if(myStr.equalsIgnoreCase("없음")) {
			return "http://localhost:8080/product/getString?str=문자열 형식으로 보내세요";
		}else {
			return "보낸 문자열은?: "+myStr;
		}
	}
	
	@RequestMapping(value = "/getUUID",method=RequestMethod.GET, produces = "text/json;charset=UTF-8")
	public String getString() {
			String strUUID=UUID.randomUUID().toString();
		return strUUID;
	}
}
