package com.biz.todo.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.todo.domain.BusVO;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class TestService {
	Gson gson=new Gson();
	
	public void testJson(Object object) {
		String strJson="";
		try {
			//여기서 바로 json형태로된 string 문자열 받음
			strJson=busTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.debug("!!! error occured");
		}
		
		/*
		 * json 안에는 내가 원하지 않는 쓸모없는 객체들이 많기 때문에 
		 * 내가 원하는 특정 데이터만 뽑기 위해 파싱을 String 형 json을 다시 
		 * JSON으로 파싱 할거임.
		 */
		//String json을 다시 공용데이터 JSON으로 변환
		JsonElement jsonElement = JsonParser.parseString(strJson);

		//공용 JSON에서 특정 객체만 String json으로 추출.
		String strBusList = jsonElement.getAsJsonObject().get("BUSSTOP_LIST").toString();
		log.debug("!!! busList: "+strBusList);
		
		//추출된 string json을 java형 VO로 변환
		List<BusVO> busList=gson.fromJson(strBusList, new TypeToken<List<BusVO>>() {}.getType());
		log.debug("!!! busList[0]: "+busList.toString());
	}
	
	public String busTest() throws IOException {
		/*
		 * 여기선 데이터를 바로 String형 json으로 받음
		 */
		StringBuilder urlBuilder = new StringBuilder("http://api.gwangju.go.kr/json/lineStationInfo"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=i7aroZN%2BLlgjJucKmTqVpL8Kd%2Fi05AThPQDDLk5MLtoNU0HjelO4288BGCOhZRMOlbWpN34p8Wbyn0Ijz0WbWQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode("i7aroZN%2BLlgjJucKmTqVpL8Kd%2Fi05AThPQDDLk5MLtoNU0HjelO4288BGCOhZRMOlbWpN34p8Wbyn0Ijz0WbWQ%3D%3D", "UTF-8")); /**/
        urlBuilder.append("&" + URLEncoder.encode("LINE_ID","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*노선 ID*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        //System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        //System.out.println(sb.toString());
        String returnData=String.valueOf(sb);
        log.debug("!!! returnData: "+returnData);
        
        //String형 json을 리턴
        return returnData;
	}
}
