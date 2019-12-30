<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>우리 애를 부탁해</title>
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191228001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/community.css?ver=20191228002"  type="text/css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){

	$("#lee-btn-update").click(function(){
		if(confirm("현재 글을 수정합니다.")) {
			let query = "${rootPath}/community/update?id=${reDTO.re_seq}"
			document.location.replace(query)
		}
	})
	
	$("#lee-btn-delete").click(function(){
		if(confirm("현재 글을 삭제합니다.")) {
			let query = "${rootPath}/community/delete?re_seq=${reDTO.re_seq}"
			document.location.replace(query)
		}
	})
		
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<div id="lee-community-view">
	<h5>후기</h5>
	<table id="lee-community-view-view">
		<tr>
			<td colspan="6" id="lee-view-subject">${reDTO.re_subject}</td>
		</tr>
		<tr>
			<td colspan="6" id="lee-view-text">${reDTO.re_text}</td>
		</tr>
		<tr id="lee-view-hide">
			<td>${reDTO.re_seq}</td>
			<td colspan="1">${reDTO.re_auth}</td>
			<td colspan="2">${reDTO.re_date}</td>
		</tr>
	</table>
	
	<div id="lee-community-btn-box">
		<a href="${rootPath}/community/list" id="lee-btn-list" class="lee-community-btn">목록</a>
		<a href="javascript:void(0)" id="lee-btn-update" class="lee-community-btn">수정</a>
		<a href="javascript:void(0)" id="lee-btn-delete" class="lee-community-btn">삭제</a>
	</div>
</div>

<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>