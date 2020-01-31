package com.biz.ems.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class NaverTokenVO {
	//네이버러부터 발급받은 token
	private String access_token;
	
	//(선택) 네이버에 token을 재발급 요청했을때 받은 token
	private String refresh_token;
	

	private String token_type;
	
	//유효기간
	private int expires_in;
	
	//(선택) 오류가 발생했을때
	private String error;
	private String error_description;
}
