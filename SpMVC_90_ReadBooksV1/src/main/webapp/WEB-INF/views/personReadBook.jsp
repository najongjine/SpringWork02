<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>
<section>
	<table>
		<tr>
		<td>일렬번호:</td>
		<td>${readBookVO.rb_seq}</td>
		</tr>
		
		<tr>
		<td>책코드:</td>
		<td>${readBookVO.rb_bcode}</td>
		</tr>
		
		<tr>
		<td>책이름:</td>
		<td>${b_name}</td>
		</tr>
		
		<tr>
		<td>날짜:</td>
		<td>${readBookVO.rb_date}</td>
		</tr>
		
		<tr>
		<td>읽기 시작 시간:</td>
		<td>${readBookVO.rb_stime}</td>
		</tr>
		
		<tr>
		<td>총 읽은시간:</td>
		<td>${readBookVO.rb_rtime}</td>
		</tr>
		
		<tr>
		<td>한줄소감:</td>
		<td>${readBookVO.rb_subject}</td>
		</tr>
		
		<tr>
		<td>평가:</td>
		<td>${readBookVO.rb_text}</td>
		</tr>
		
		<tr>
		<td>평점:</td>
		<td>${readBookVO.rb_star}</td>
		</tr>
	</table>
</section>
</body>
</html>