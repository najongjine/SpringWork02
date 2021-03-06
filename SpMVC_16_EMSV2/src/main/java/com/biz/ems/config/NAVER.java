package com.biz.ems.config;

public class NAVER {
	public static class TOKEN {
		public static final String grant_type = "grant_type";// string Y - 인증 과정에 대한 구분값
		public static final String client_id = "client_id";// string Y - 애플리케이션 등록 시 발급받은 Client ID 값
		public static final String client_secret = "client_secret";// string Y - 애플리케이션 등록 시 발급받은 Client secret 값
		public static final String code = "code";// string 발급 때 필수 - 로그인 인증 요청 API 호출에 성공하고 리턴받은 인증코드값 (authorization
													// code)
		public static final String state = "state";// string 발급 때 필수 - 사이트 간 요청 위조(cross-site request forgery) 공격을 방지하기
													// 위해 애플리케이션에서 생성한 상태 토큰값으로 URL 인코딩을 적용한 값을 사용
		public static final String refresh_token = "refresh_token";// string 갱신 때 필수 - 네이버 사용자 인증에 성공하고 발급받은 갱신
																	// 토큰(refresh token)
		public static final String access_token = "access_token";// string 삭제 때 필수 - 기 발급받은 접근 토큰으로 URL 인코딩을 적용한 값을 사용
		public static final String service_provider = "service_provider";// string
	}

	public static class GRANT_TYPE {
		public static final String authorization_code = "authorization_code";
		public static final String refresh_token = "refresh_token";
		public static final String delete = "delete";
	}
}
