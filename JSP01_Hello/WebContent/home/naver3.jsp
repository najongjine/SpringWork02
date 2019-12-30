<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- anchor -->
<!-- 다른곳으로 연결하는 링커.
href:= 다른곳으로 점프하는 코드
 -->
<p><a href="https://search.naver.com/search.naver?query=이번년도블랙프라이데이">네이버검색</a>
<p><a href="https://search.naver.com/search.naver?q=이번년도블랙프라이데이">네이버검색2</a></p>
<p>네이버 검색</p>
<!-- input box, input tag -->
<form action="https://search.naver.com/search.naver" target="_NEW">
<label>네이버</label><input name="query">
</form>
<form action="https://google.com/search" target="_NEW">
<label>구글</label><input name="q">
</form>
<form action="https://search.daum.net/search" target="_NEW">
<label>다음</label><input name="q">
</form>

</body>
</html>