package com.biz.pet.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.biz.pet.domain.RealEstateVO;
import com.biz.pet.domain.STourVO;
import com.biz.pet.domain.fwfsh.WaterFishingVO;
import com.biz.pet.domain.stourrest.STourRestResponse;
import com.biz.pet.domain.stourrest.json.GetVO;
import com.biz.pet.domain.stourrest.json.STourVOJSON;
import com.biz.todo.domain.restRealEst.RestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TourService {
	private final String serviceApiUrl="http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode";

	public String getQueryHeader(String dealYmd) {
		String queryString=serviceApiUrl;
		queryString += "serviceKey=i7aroZN%2BLlgjJucKmTqVpL8Kd%2Fi05AThPQDDLk5MLtoNU0HjelO4288BGCOhZRMOlbWpN34p8Wbyn0Ijz0WbWQ%3D%3D";
		queryString += "&MobileOS=ETC";
		queryString+="&MobileApp=Fisher";
		
		queryString += "&contentTypeId=28";
		//queryString += "&cat1=A03";
		//queryString += "&cat1=A0303"; 
		queryString += "&cat1=A03030500";
		//queryString +="&_type=json";

		return queryString;
	}// end
	
	// XML을 rest template으로 받아야 하는건 맞음
	public List<STourVO> getServiceTourXML() {
		String serviceTourQueryString=getQueryHeader("test");
		String testPerfectURI="http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode?serviceKey=i7aroZN%2BLlgjJucKmTqVpL8Kd%2Fi05AThPQDDLk5MLtoNU0HjelO4288BGCOhZRMOlbWpN34p8Wbyn0Ijz0WbWQ%3D%3D"
				+ "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentTypeId=28&cat1=A03&cat2=A0303&cat3=A03030500";
		log.debug("!!! query string: "+serviceTourQueryString);
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);
		RestTemplate restTemp = new RestTemplate();
		URI restURI = null;
		ResponseEntity<STourRestResponse> result = null;
		try {
			restURI = new URI(testPerfectURI);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, STourRestResponse.class);
			STourRestResponse rVO = result.getBody();
			log.debug("!!! rVO: "+rVO.toString());
			//List<STourVO> sTourList = rVO.body.items.item;
			//List<STourVO> sTourList = rVO.getBody().items.item;
//			return sTourList;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// XML을 rest template으로 받아야 하는건 맞음
		public List<WaterFishingVO> getWaterFishingLoc() {
			String areaBasedURL="http://api.visitkorea.or.kr/openapi/service/rest/EngService/areaBasedList";
			areaBasedURL+="?serviceKey=i7aroZN%2BLlgjJucKmTqVpL8Kd%2Fi05AThPQDDLk5MLtoNU0HjelO4288BGCOhZRMOlbWpN34p8Wbyn0Ijz0WbWQ%3D%3D";
			areaBasedURL+="&cat3=A03030500";
			HttpHeaders header = new HttpHeaders();
			header.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_XML));
			HttpEntity<String> entity = new HttpEntity<String>("parameters", header);
			RestTemplate restTemp = new RestTemplate();
			URI restURI = null;
			ResponseEntity<STourRestResponse> result = null;
			try {
				restURI = new URI(areaBasedURL);
				result = restTemp.exchange(restURI, HttpMethod.GET, entity, STourRestResponse.class);
				STourRestResponse rVO = result.getBody();
				log.debug("!!! rVO: "+rVO.toString());
				List<WaterFishingVO> waterFshList = rVO.body.items.item;
				//List<STourVO> sTourList = rVO.getBody().items.item;
				return waterFshList;
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
	// Json을 rest template으로 받는건 보류
	public List<STourVOJSON> getServiceTourJSON() {
		String serviceTourQueryString=getQueryHeader("test");
		String testPerfectURI="http://api.visitkorea.or.kr/openapi/service/rest/KorService/categoryCode?serviceKey=i7aroZN%2BLlgjJucKmTqVpL8Kd%2Fi05AThPQDDLk5MLtoNU0HjelO4288BGCOhZRMOlbWpN34p8Wbyn0Ijz0WbWQ%3D%3D"
				+ "&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&contentTypeId=28&cat1=A03";
				//+ "&cat2=A0303&cat3=A03030500";
		testPerfectURI +="&_type=json";
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);
		RestTemplate restTemp = new RestTemplate();
		URI restURI = null;
		ResponseEntity<GetVO> result = null;
		try {
			restURI = new URI(testPerfectURI);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, GetVO.class);
			GetVO rVO = result.getBody();
			log.debug("!!! rVO: "+rVO.toString());
			//List<STourVO> sTourList = rVO.body.items.item;
			List<STourVOJSON> sTourList = rVO.getResponse().getBody().getItems().getItem();
			return sTourList;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<RealEstateVO> getRestVoList(String dealYmd) { // 공공DB에서 데이터를 걍 String으로만 가져오는 method
		String queryString=getQueryHeader(dealYmd);

		// HttpReq 헤더 설정하기
		HttpHeaders header = new HttpHeaders();
		// header.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_JSON_UTF8));
		header.setAccept(Collections.singletonList(org.springframework.http.MediaType.APPLICATION_XML));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", header);

		// Spring 3.2에서 도입된 새로운 HttpConnection 추상화된 객체
		RestTemplate restTemp = new RestTemplate();
		URI restURI = null;
		// ResponseEntity<String> restList=null;
		ResponseEntity<RestVO> result = null;
		try {
			restURI = new URI(queryString);
			result = restTemp.exchange(restURI, HttpMethod.GET, entity, RestVO.class);
			RestVO rVO = (RestVO) result.getBody();
			log.debug("!!! rVO: "+rVO.toString());
			List<RealEstateVO> realEstList = rVO.body.items.item;
			log.debug("!!! realEstateList: (in service)"+realEstList.toString());
			return realEstList;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}// end

}
