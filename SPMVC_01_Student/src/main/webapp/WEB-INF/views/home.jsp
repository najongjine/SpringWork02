<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	나의 홈페이지
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p><a href="input">학생정보 입력: </a>
<p><a href="list">학생리스트 </a>
<p><a href="search">학생정보 검색: </a>
<p><a href="login">로그인: </a>
<p><a href="join">회원가입: </a>
</body>
</html>
