package com.biz.ems.service;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.biz.ems.config.NAVER;
import com.biz.ems.domain.NaverMember;
import com.biz.ems.domain.NaverMemberResponse;
import com.biz.ems.domain.NaverReturnAuth;
import com.biz.ems.domain.NaverTokenVO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NaverLoginService {
	@Value("${naver.client.id}")
	private String clientId;
	
	@Value("${naver.client.secret}")
	private String clientSec;
	
	private final String loginAPI_URL="https://nid.naver.com/oauth2.0/authorize";
	private final String tokenAPI_URL="https://nid.naver.com/oauth2.0/token";
	private final String naverMemberAPI_URL="https://openapi.naver.com/v1/nid/me";
	private final String callbackLocalURL="http://localhost:8080/ems_najongjine/member/naver/ok";
	private final String callbackURL="https://callor.com:12600/ems_najongjine/member/naver/ok";
	
	public String oAuthLoginGet() {
		/*
		String redirectURI=null;
		try {
			redirectURI=URLEncoder.encode(callbackURL,"UTF-8");
					//"https://callor.com:12600/ems/naver/ok","UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		SecureRandom random=new SecureRandom();
		
		//최대값 130bit 크기 임의의 정수를 생성하여 문자열로 만들어라.
		String stateKey=new BigInteger(130,random).toString();
		log.debug("!!! STATE KEY: "+stateKey);
		
		/*
		 * www.xxx.com?y=y&z=z 만드는 클래스
		 * Spring 4.1에서 사용하는 UriQuery 문자열을 생성하는 클래스
		 * fromHttpUrl(): 요청을 수행할 server 주소.
		 * queryParam():변수=값 형태의 query문자열 생성
		 * build(true): 생성하는 문자열중에 encoding이 필요한 부분이 있으면 encoding을 수행하라.
		 * 5.1 이상에서는 별도로 encoding() method가 있다.
		 * queryParam("name","korea") &name=korea
		 * queryParam("name","korea","usa") &name=korea&name=usa
		 */
		String apiURL=
		UriComponentsBuilder.fromHttpUrl(loginAPI_URL).queryParam("client_id", clientId)
		.queryParam("response_type", "code")
		.queryParam("redirect_uri", callbackURL)
		.queryParam("state", stateKey).build(true).toUriString();
		
		/*
		 * Get 방식 URL 만듬
		 
		String apiURL=loginAPI_URL;
		apiURL+="?client_id="+clientId;
		apiURL+="&response_type=code";
		apiURL+="&redirect_uri="+redirectURI;
		apiURL+="&state="+stateKey;
		
		log.debug("URL: "+apiURL);
		*/
		
		return apiURL;
	}
	
	/*
	 * 네이버에 정보요규를 할때 사용할 토큰을 요청
	 * token을 요청할때 GET/POST method를 사용할수 있는데
	 * 여기서는 POST를 사용해서 요청을 하겠다.
	 * 
	 * @param naverok
	 */
	public NaverTokenVO oAuthAccessGetToken(NaverReturnAuth naverOK) {
		
		/*
		 * 옵션
		 */
		HttpHeaders headers=new HttpHeaders();
		headers.set("X-Naver-Client-Id",clientId);
		headers.set("X-Naver-Client-Secret",clientSec);
		
		/*
		 * Map interface를 상속받아 작성된 spring framework 전용 map 인터페이스
		 * http protocol과 관련된 곳에서 기본 map 대신 사용하는 클래스
		 * http protocol과 관련된 내장 method가 포함되어 있다.
		 * 
		 * Post방식 request parameter 만들기
		 */
		MultiValueMap<String,String> bodies=new LinkedMultiValueMap<String, String>();
		
		bodies.add(NAVER.TOKEN.grant_type,NAVER.GRANT_TYPE.authorization_code);
		bodies.add(NAVER.TOKEN.client_id, clientId);
		bodies.add(NAVER.TOKEN.client_secret, clientSec);
		bodies.add(NAVER.TOKEN.code, naverOK.getCode());
		bodies.add(NAVER.TOKEN.state, naverOK.getState());
		
		//headers에 담긴 정보와 bodies에 담긴정보를 HttpEntity 데이터로 변환
		// body 부분에 parameter 실음
		HttpEntity<MultiValueMap<String, String>> request=new HttpEntity<MultiValueMap<String,String>>(bodies,headers);
		
		/*
		 * 옵션
		 */
		URI restURI=null;
		try {
			restURI=new URI(tokenAPI_URL);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * RestTemplate을 사용하여 네이버에 token을 요청
		 */
		RestTemplate restTemp=new RestTemplate();
		ResponseEntity<NaverTokenVO> result=null;
		
		// Post일 경우 URL Encoding은 옵션. 주소가 only english 일 경우 encoding 안해도 됨
		result=restTemp.exchange(tokenAPI_URL, HttpMethod.POST,request,NaverTokenVO.class);
		log.debug("naver_token: "+result.getBody().toString());
		return result.getBody();
	}
	
	public NaverMember getNaverMemberInfo(NaverTokenVO tokenVO) {
		String token=tokenVO.getAccess_token();
		String header="bearer "+token;
		
		//header 문자열을 get의 http header에 실어서 get 방식으로 요청을한다.
		HttpHeaders headers=new HttpHeaders();
		headers.add("Authorization", header);
		
		/*
		 * body부분에 parameter라는 문자열을 추가하고
		 * header부분에 위의 headers에서 설정한 형식으로 생성하고
		 *  Authorization="bearer..."
		 * 모두 문자열로 변환하여 http Protocol 데이터 구조로 변경한다.
		 * 그리고 HttpProtocol을 사용하여 데이터를 전송할수 있도록
		 * 준비를 한다.
		 * HttpEntity<String> 형식으로 선언하면: 단일 생성 방식
		 * 
		 * HttpEntity<MultiValue<String,Object>> 형식으로 선언하면
		 * body 부분에 데이터를 다음과 같이 생성
		 *  변수=[값],변수=[값]
		 * header 부분의 데이터는 [변수:값, 변수:값]
		 */
		//"parameter" 는 그냥 dummy body
		HttpEntity<String> request=new HttpEntity<String>("parameter",headers);
		log.debug("!!! entity: "+request.toString());
		
		ResponseEntity<NaverMemberResponse> result;
		RestTemplate restTemp=new RestTemplate();
		result=restTemp.exchange(naverMemberAPI_URL, HttpMethod.GET,request,NaverMemberResponse.class);
		
		NaverMember member=result.getBody().response;
		return member;
	}
}
