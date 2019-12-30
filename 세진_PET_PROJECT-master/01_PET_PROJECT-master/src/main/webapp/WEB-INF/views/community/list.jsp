<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>우리 애를 부탁해</title>
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191228001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/community.css?ver=20191228001"  type="text/css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	
	$("#lee-btn-write").click(function(){
		document.location.href = "${rootPath}/community/insert"
	})
	
	$(".lee-content-body").click(function(){
		let id = $(this).attr("data-id")
		let auth = $(this).attr("data-auth")
		document.location.href = "${rootPath}/community/view?id=" + id
	})
	
})
</script>
<style type="text/css">
#lee-community-nav>ul>li:first-child a {
	background-color: #e67e22;
	color: white;
}

#lee-community-nav>ul>li>a:hover {
	background-color: #e67e22;
	color: white;
}
</style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<div id= "lee-community">
	<section id="lee-community-nav">
		<ul>
			<li><a href="${rootPath}/community/list">후기</a></li>
			<li><a href="${rootPath}/community/service/list">고객센터</a></li>
		</ul>
	</section>
	
	<table id="lee-community-lists">
	<tr>
		<th id="lee-community-list1" class="lee-community-list">번호</th>
		<th id="lee-community-list2" class="lee-community-list">제목</th>
		<th id="lee-community-list3" class="lee-community-list">작성자</th>
		<th id="lee-community-list4" class="lee-community-list">작성일</th>
	<tr>
	<c:choose>
		<c:when test="${empty RELIST}">
			<tr>
				<td>후기가 없습니다</td>
			</tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${RELIST}" var="reDTO" varStatus="index">
				<tr class="lee-content-body" data-id="${reDTO.re_seq}">
					<td class="lee-community-list-td">${reDTO.re_seq}</td>
					<td id="lee-community-subject" class="lee-community-list-td">${reDTO.re_subject}</td>
					<td class="lee-community-list-td">${reDTO.re_auth}</td>
					<td class="lee-community-list-td">${reDTO.re_date}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>

	<form id="lee-community-search-form">
		<input type="search" class="form-control" id="lee-community-search-input" name="search" value="${search}" 
			placeholder="검색할 제목을 입력한 후 Enter">
	</form>

	<%@ include file="/WEB-INF/views/community/pagination.jsp" %>
	
	<button id="lee-btn-write">글쓰기</button>
</div>

<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>