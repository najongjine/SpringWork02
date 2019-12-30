package com.biz.naver.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.naver.config.NaverConfig;
import com.biz.naver.domain.PageDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NaverServiceV2 {
	private final String naver_news_url = "https://openapi.naver.com/v1/search/news.json";
	private final String naver_book_url = "https://openapi.naver.com/v1/search/book.json";
	private final String naver_movie_url = "https://openapi.naver.com/v1/search/movie.json";
	
	@Autowired
	PageService pService;

	public PageDTO getPage(String cat, String search, long currentPageNo) throws IOException, ParseException {
		//전체데이서 개수 계산
		String totalQuery=queryNaver(cat, search);
		String totalString=getNaverString(totalQuery);
		JSONObject totalJObject=strToJson(totalString);
		
		//JSONO에서 key가 total인 항목을 찾아서 값을 문자열로 추출
		String strTotalCount=totalJObject.get("total").toString(); // 여기서 total은 네이버가 제공하는 메서드 같은거임
		long totalCount=Long.valueOf(strTotalCount);
		if(totalCount>1000) totalCount=1000;
		PageDTO pageDTO=pService.makePageNation(totalCount, currentPageNo);
		log.debug("전체갯수: "+totalCount);
		
		return pageDTO;
	}
	//0.
	public JSONArray getNaver(String cat,String search, long currentPageNo) throws IOException, ParseException {
		PageDTO pageDTO=getPage(cat, search, currentPageNo);
		
		//1.  1:1~11, 2: 11~20, 3:21~30
		if(currentPageNo<1) currentPageNo=1;
		else currentPageNo=(currentPageNo-1)*pageDTO.getListPerPage() +1;
		String queryString = queryNaver(cat, search, currentPageNo
				,pageDTO.getListPerPage());
		//2
		String resString=getNaverString(queryString);
		//3
		JSONObject resObject=strToJson(resString);
		//4
		JSONArray resArray=getArray(resObject, "items");
		
		return resArray;
	}
	//1. cat, search, start, display 값을 매개변수로 받아서
	//start 부터 disp 갯수만큼 데이터를 가져오기위한 queryString을 생성
	public String queryNaver(String cat, String search) throws UnsupportedEncodingException {
		String queryString=URLEncoder.encode(search,"UTF-8");
		queryString=this.queryURL(cat)+"?query="+queryString;
		return queryString;
	}//end
	public String queryNaver(String cat, String search, long start, long display) throws UnsupportedEncodingException {
		String queryString=URLEncoder.encode(search,"UTF-8");
		queryString=this.queryURL(cat)+"?query="+queryString;
		
		//start display 값을 query에 포함하면
		//start 부터 display 갯수만큼 데이터ㅏ를 보내라는 의미
		queryString+="&start="+start;
		queryString+="&display="+display;
		return queryString;
	}//end
	
	//2. query 네니버에서 생성한 queryString 문자열을 매개변수로 받아서
	//naver에게 전송하고 response된 문자열을 return 하도록
	public String getNaverString(String queryString) throws IOException {
		URL url=new URL(queryString);
		HttpURLConnection httpConn=(HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("GET");
		httpConn.setRequestProperty("X-Naver-Client-Id", NaverConfig.NaverClientId);
		httpConn.setRequestProperty("X-Naver-Client-Secret", NaverConfig.NaverClientSecret);
		int resCode=httpConn.getResponseCode();
		BufferedReader buffer=null;
		if(resCode==200) {
			InputStreamReader is=new InputStreamReader(httpConn.getInputStream());
			buffer=new BufferedReader(is);
		} else {
			//when error occur
			InputStreamReader is=new InputStreamReader(httpConn.getErrorStream());
			buffer=new BufferedReader(is);
		}
		StringBuffer resString=new StringBuffer();
		String reader="";
		while(true) {
			reader=buffer.readLine();
			if(reader==null) break;
			resString.append(reader);
		}
		//디버깅을 위한 코드
		if(resCode==200) {
			return resString.toString();
		}else {
			log.debug("네이버 오류: "+resString.toString());
			
		}//end
		return null;
	}// end
	
	//3. naver에서 response한 문자열을 통째로 JSON Object로 변환
	//문자열을 JSONObject로 변환
	public JSONObject strToJson(String jsonString) throws ParseException {
		JSONParser jParser=new JSONParser();
		JSONObject jObject=(JSONObject) jParser.parse(jsonString);
		return jObject;
	}
	
	
	//4. JSONObject로부터 naver의 items만 추출하여 JSONArray로 변환
	//naver로부터 받은 데이터에서 items 항목을 추출하여
	//실제 데이터들을 Array로 만들어주는 method
	public JSONArray getArray(JSONObject jObject,String keyString) {
		return (JSONArray) jObject.get(keyString);
	}
	
	public String queryURL(String cat) {
		String queryURL=naver_news_url;
		if (cat.equalsIgnoreCase("NEWS")) {
			queryURL=naver_news_url;
		}
		else if (cat.equalsIgnoreCase("BOOK")) {
			queryURL=naver_book_url;
		}
		else if (cat.equalsIgnoreCase("MOVIE")) {
			queryURL=naver_movie_url;
		}
		return queryURL;
	}// end
	
	
	
}
