package com.biz.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.biz.product.domain.ProductDTO;
import com.biz.product.service.FileService;
import com.biz.product.service.ProductSerivce;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ProductController {
	@Autowired
	FileService fService;
	@Autowired
	ProductSerivce pService;

	// @ResponseBody
	@RequestMapping(
			value="plist",
			method=RequestMethod.GET,
			produces = "application/json;charset=UTF-8;")
	public String getPlist(Model model) {
		List<ProductDTO> proList = pService.selectAll();
		
		model.addAttribute("PLIST",proList);
		return "home";
	
	}
	
	@RequestMapping(value = "imgDelete",method=RequestMethod.GET)
	public String imgDelete(String p_code) {
		log.debug("!!! pcode: "+p_code);
		ProductDTO proDTO=pService.findByPCode(p_code);
		if(proDTO.getP_file()!=null && !proDTO.getP_file().isEmpty()) {
			fService.fileDelete(proDTO.getP_file());
			proDTO.setP_file(null);
			pService.update(proDTO);
		}
		return "redirect:/plist";
	}
	
	@RequestMapping(value = "/input", method=RequestMethod.POST)
	public String input(@ModelAttribute ProductDTO proDTO, 
			@RequestParam("u_file") MultipartFile u_file) {
		log.debug("상품정보 입력: "+proDTO.toString());
		log.debug("업로드한 파일:"+u_file.getOriginalFilename());
		
		if(!u_file.isEmpty()) {
			//update 할때 이미 upload된 파일이 있으면 기존의 파일을 삭제하고 새로운 파일을 업로드 해야함으로
			//p_file 변수를 검사하여 값이 있으면 파일을 삭제하자.
			if(proDTO.getP_file()!=null) {
				fService.fileDelete(proDTO.getP_file());
			}
			String upFileName=fService.fileUp(u_file);
			if(upFileName!= null) {
				/*
				 * 정상적으로 저장이 완료되면 파일이름을 DTO에 p_file 변수에 저장을 한다.
				 * 
				 */
				proDTO.setP_file(upFileName);
			}
			
		}
		/*
		 * web에서 파일이 전송되어 오면 fService.fileUp() method에게
		 * 파일을 어딘가에 저장해달라고 요청.
		 */
		
		int ret=0;
		if(proDTO.getP_code().isEmpty()) {
			log.debug("새로운 상품등록");
			ret=pService.insert(proDTO);
		} else {
			log.debug("기존 상품변경");
			ret=pService.update(proDTO);
		}
		return "redirect:/plist";
	}

	/*
	 * 결과물을 view(jsp)로 변환하지 않고 문자열 그대로 또는 객체(vo|dto)를 json 형태로 변경하여
	 * client에게 response를 수행하는 기능
	 */
	/*
	@ResponseBody
	@RequestMapping(value = "getProduct",method=RequestMethod.GET,produces="application/json;charset=UTF-8")
	public ProductDTO getProduct(String p_code) {
		ProductDTO proDTO=pService.findByPCode(p_code);
		return proDTO;
	}*/
	
	@ResponseBody
	@RequestMapping(value = "getString",method=RequestMethod.GET, produces = "application/json;charset=UTF-8")
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
	
	@ResponseBody
	@RequestMapping(
			value="plist/name",
			method=RequestMethod.GET,
			produces = "application/json;charset=UTF-8;")
	
	public List<ProductDTO> getNames(String p_name) {
		List<ProductDTO> proList = pService.findByPNames(p_name);
		return proList;
	}
	

	/*
	 * produces의 content-Type
	 * 서버에서 문자열, 객체 등등의 실제 데이터를 response할때
	 * 어떤 type으로 보낼것인가를 나타내는 문자열
	 * 
	 */
	@ResponseBody
	@RequestMapping(
			value="pname",
			method=RequestMethod.GET,
			produces = "text/plain;charset=UTF-8;")
	public String getPName(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		// return proDTO.getP_name();
		return "<h1>" + proDTO.getP_name() + "</h1>";
		
	}

	
	@ResponseBody
	@RequestMapping(
			value="oprice",
			method=RequestMethod.GET,
			produces = "text/html;charset=UTF-8")
	public String getOPrice(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		return proDTO.getP_oprice()+"";
		
	}

	@ResponseBody
	@RequestMapping(
			value="iprice",
			method=RequestMethod.GET,
			produces = "text/html;charset=UTF-8")
	public String getIPrice(String p_code) {
		
		ProductDTO proDTO = pService.findByPCode(p_code);
		return proDTO.getP_iprice()+"";
	}
	
	
	

}
