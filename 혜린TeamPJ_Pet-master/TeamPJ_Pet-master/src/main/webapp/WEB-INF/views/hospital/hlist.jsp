<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원찾기</title>
<link rel="stylesheet" href="${rootPath}/css/pagination.css?ver=2019121202354" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){
	
	$(".content-body").click(function(e){
		let id = $(this).attr("data-id")
		document.location.href="${rootPath}/hospital/viewdetail?id=" + id
	})			
	
	$("#btn-insert").click(function(){
		document.location.href = "${rootPath}/hospital/insert"
	})
})
</script>
</head>
<style>
table {
	width: 1100px;
	border-top: 1px solid #444444;
	border-collapse: collapse;
	right: 30px;;
}

th, td {
	border-bottom: 1px solid #444444;
	padding: 5px;
}

table tr th {
	background-color: rgba(162, 205, 12, 0.4);
	font-size: 17px;
	font-weight: bold;
	text-align: left;
}

tr.content-body:hover {
	background-color: #ddd;
	cursor: pointer;
}

#empty-list{
	text-align: center;
}

div#btn-insert #h-insert{
	float: right;
	padding: 10px 14px;
	color: green;
	border-radius: 10px;	
	margin: 20px;
}

div#btn-insert #h-insert:hover{
	background-color: #E9ECEF;
}

#search-out{
	width: 100%;
	text-align: center;
	margin-block-start: 1em;
}

#hs-search {
	display: inline-block;
	position:relative;
	display: flex;
	width: 60%;
	margin: 0 auto;
}

#search-out #dong-search {
	font-size: 0.8rem;
	text-align: center;
	width: 526px;
	padding: 14px 20px;
}

#btn-dong {
	position: absolute;
	top: 0;
	right: 0;
	border: none;
	background-color: #14974b;
	color: white;
	font-size: 0.8rem;
	padding: 14px 20px;
	cursor: pointer;
}

#btn-dong:hover {
	background-color: #7bc043;
}
</style>
<body>

<!-- 병원 리스트들을 보여줄 table -->
<table>
	<tr>
		<th>No</th>
		<th>이름</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>기타동물</th>
		<th>가격정보</th>
	</tr>
	<c:choose>
		<c:when test="${empty H_LIST}">
			<tr><td colspan="6" id="empty-list">리스트 없음</td>
		</c:when>
		<c:otherwise>
			<c:forEach items="${H_LIST}" var="hDTO" varStatus="index">
				<tr class="content-body" data-id="${hDTO.h_seq}">
					<td>${index.count}</td>
					<td>${hDTO.h_name}</td>
					<td>${hDTO.h_addr}</td>
					<td>${hDTO.h_tel}</td>
					<td>${hDTO.h_etc}</td>
					<td>${hDTO.h_price}</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</table>
<article class="page-box">
	
	<ul class="page-body">
		<c:if test="${pageDTO.startPageNo > 1 }">
			<li class="page-item"><a href="${rootPath}/hospital/hlist?currentPageNo=1" class="page-link">1</a></li>
			<li class="page-item"><a href="${rootPath}/hospital/hlist?currentPageNo=${pageDTO.prePageNo}" class="page-link">&lt;</a></li>
		</c:if>

		<c:forEach begin="${pageDTO.startPageNo}" end="${pageDTO.endPageNo}" var="pageNo">
				<li class="page-item <c:if test="${pageNo == pageDTO.currentPageNo}">active</c:if>">
					<a class="page-link" href="${rootPath}/hospital/hlist?currentPageNo=${pageNo}">${pageNo}</a></li>
		</c:forEach>
		
		<c:if test="${pageDTO.endPageNo != pageDTO.finalPageNo}">
			<li class="page-item"><a class="page-link" href="${rootPath}/hospital/hlist?currentPageNo=${pageDTO.nextPageNo}">&gt;</a></li>
			<li class="page-item"><a class="page-link" href="${rootPath}/hospital/hlist?currentPageNo=${pageDTO.finalPageNo}">${pageDTO.finalPageNo}</a></li>
		</c:if>
		
	</ul>
	
</article>

<div id="btn-insert">
	<button id="h-insert">병원추가</button>
</div>

<div id="search-out">
	<form id="hs-search">
		<input type="search" placeholder="동을 입력하세요 (ex) 삼각동, 두암동 등)" id="dong-search">
		<button id="btn-dong">검색</button>
	</form>
</div>

</body>
</html>