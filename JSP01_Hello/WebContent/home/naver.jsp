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
<form action="/JSP01_Hello/home/home1.jsp">
<p><input name="query">
<p><input name="num1">
<p><input name="num2">
<button>검색</button>
</form>

</body>
</html>