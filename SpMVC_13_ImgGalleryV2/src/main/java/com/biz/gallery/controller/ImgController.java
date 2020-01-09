package com.biz.gallery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.gallery.domain.ImageFilesVO;
import com.biz.gallery.domain.ImageVO;
import com.biz.gallery.service.ImageFileService;
import com.biz.gallery.service.ImageService;
import com.biz.gallery.service.ImageServiceV2;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@SessionAttributes({"imageVO"})
@Controller
@RequestMapping(value = "/image")
public class ImgController {
	ImageServiceV2 imService;
	
	@Autowired
	public ImgController(ImageServiceV2 imService) {
		this.imService=imService;
	}
	
	@Autowired
	ImageFileService ifService;
	
	@ModelAttribute("imageVO")
	public ImageVO newImageVO() {
		return new ImageVO();
	}
	
	@RequestMapping(value = "/list",method=RequestMethod.GET)
	public String list(Model model) {
		List<ImageVO> imgList=imService.selectAll();
		model.addAttribute("imgList", imgList);
		return "home";
	}
	@RequestMapping(value = "/upload",method=RequestMethod.GET)
	public String upload(@ModelAttribute("imageVO") ImageVO imageVO,Model model) {
		log.debug("이미지 업로드 시작!@!");
		imageVO=new ImageVO();
		model.addAttribute("BODY", "UPLOAD");
		model.addAttribute("imageVO", imageVO);
		return "home";
	}
	
	@RequestMapping(value = "/upload", method=RequestMethod.POST)
	public String upload(@ModelAttribute("imageVO") ImageVO imageVO,SessionStatus status
			) {
		/*
		 * 실제 파일을 경로에 upload 하는건 home.jsp의 script 부분에서 다 끝내고,
		 * 여기선 그냥 파일 이름을 DB에 저장만
		 */
		imService.insert(imageVO);
		status.setComplete();
		return "redirect:/image/list";
	}
	
	/*
	 * reqparam: ?변수=값 형식으로 전송하고 변수에서 수신
	 * @PathVariable: path/값 형식으로 전송하고 변수에서 받기
	 */
	@RequestMapping(value = "/update/{img_seq}",method=RequestMethod.GET)
	public String update(@PathVariable("img_seq") String img_seq,Model model) {
		ImageVO imgVO=imService.findBySeq(img_seq);
		model.addAttribute("BODY", "UPLOAD");
		model.addAttribute("imageVO", imgVO);
		return "home";
	}
	
	@RequestMapping(value = "/update/{image_seq}",method=RequestMethod.POST)
	public String update(@ModelAttribute("imageVO") ImageVO imageVO, SessionStatus status) {
		//이미지 이름이 기존이미지오 ㅏ다르면 삭제
		int ret=imService.update(imageVO);
		
		/*
		 * sessionattribute을 사용할때 객체가 서버 메모리에 남아서 계속 유지되는 상태.
		 * insert, update등을 수행할때 그 정보를 계속사용해서 form에 값이 나타나게 된다.
		 * 그것을 방지하기 위해서 insert,update 완료된 후에는 반드시 sessionstatus의 setcomplete()
		 * method를 호출해서 sessionattribute을 해제해 주어야 한다.
		 */
		status.setComplete();
		return "redirect:/image/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete",method=RequestMethod.POST)
	public String delete(@RequestParam("img_seq") String img_seq, SessionStatus status,Model model) {
		int ret=imService.delete(img_seq);
		status.setComplete();
		return ret+"";
	}
	
	/*
	 * MultipartHttpServletRequest:= 다중파일 수신하기
	 */
	@RequestMapping(value = "/files_up",method=RequestMethod.POST)
	public String files_up(MultipartHttpServletRequest mFiles,Model model) {
		log.debug("!!! files_up called");
		List<ImageFilesVO> fileNames=imService.files_up(mFiles);
		model.addAttribute("imgList", fileNames);
		return "/include/img_card_box";
	}
	
	@ResponseBody //내가 만든거
	@RequestMapping(value = "/deleteSubImg",method=RequestMethod.POST)
	public String deleteSubImg(@RequestParam("img_file_seq") String strSeq) {
		long img_file_seq=-1;
		try {
			img_file_seq=Long.valueOf(strSeq);
		} catch (Exception e) {
			log.debug("자료형변환 오류");
		}
		log.debug("시퀀스값:"+img_file_seq);
		int ret=ifService.deleteBySeq(img_file_seq);
		return ret+"";
	}
}
