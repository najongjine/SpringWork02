<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="${rootPath}/css/rbook-main.css?ver=2020-01-14-001" rel="stylesheet" type="text/css">
<link href="${rootPath}/css/main-table.css?ver=2020-01-14-001" rel="stylesheet" type="text/css">
<link href="${rootPath}/css/color.css?ver=2020-01-14-001" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function() {
	$("#btn-write").click( ()=> {
		document.location.href="${rootPath}/book/write"
	})
})
</script>
</head>
<body>
<header>
	<h2>My Read Book</h2>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<section id="main-list">
	<table id="main-table">
		<thead>
		<tr>
			<th>도서코드</th>
			<th>도서이름</th>
			<th>출판사</th>
			<th>저자</th>
			<th>구입일자</th>
			<th>가격</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach items="${BLIST}" var="BOOK">
				<tr>
				<td>${BOOK.b_code}</td>
				<td>${BOOK.b_name}</td>
				<td>${BOOK.b_comp}</td>
				<td>${BOOK.b_auther}</td>
				<td>${BOOK.b_year}</td>
				<td>${BOOK.b_iprice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>

<section>
	<div id="main-button">
		<button id="btn-write" class="biz-blue flex-right">독서록 작성</button>
	</div>
</section>
</body>
</html>