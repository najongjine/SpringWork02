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
import com.biz.todo.domain.restRealEst.RestVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RealEstService {
	// 경기도 https://openapi.gg.go.kr/Animalhosptl?
	private final String apiUrl = "http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcNrgTrade";

	public String getQueryHeader(String dealYmd) {
		String queryString = apiUrl;
		queryString += "?serviceKey=i7aroZN%2BLlgjJucKmTqVpL8Kd%2Fi05AThPQDDLk5MLtoNU0HjelO4288BGCOhZRMOlbWpN34p8Wbyn0Ijz0WbWQ%3D%3D";
		queryString += "&DEAL_YMD="+dealYmd;
		queryString += "&LAWD_CD=11110";

		return queryString;
	}// end

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
