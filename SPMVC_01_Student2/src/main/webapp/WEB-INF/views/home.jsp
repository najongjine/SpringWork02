<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%/*
<C:set var="새로운 변수" value="${기존변수}"/>
기존변수(변수명이 매우 길어서 불편할경우)를
새로운 변수에 임시 할당하여 jsp코드내에서ㅗ 자유롭게 사용하는 방법

pageContext: jsp에 설정된 전역 객체, 여러가지 정보를 담고있다
request: web에서 전송된 여러가지 정보가 담긴 sub 객체
contextPath: 프로젝트의 context 문자열을 담고있는 필드변수

String rootPath=pageContext.request.contextPath;
*/ %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	나의 홈페이지
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p><a href="${rootPath }/input">학생정보 입력: </a>
<p><a href="${rootPath }/list">학생리스트 </a>
<p><a href="${rootPath }/search">학생정보 검색: </a>
<p><a href="${rootPath }/login">로그인: </a>
<p><a href="<c:url value='/join'/>">회원가입: </a>
</body>
</html>
