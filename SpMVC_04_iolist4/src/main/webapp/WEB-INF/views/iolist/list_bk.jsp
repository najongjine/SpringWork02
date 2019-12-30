<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<title>□□□ My JSP Page □□□</title>
</head>
<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
<script>
$(function() {
	$("#insert_IolistDTO").click(function (e) {
		document.location.href = "${rootPath}/iolist/insert"
	})
})
</script>
<body>
<label>Insert new Data</label><button id="insert_IolistDTO">insert</button>
	<c:choose>
		<c:when test="${empty IOLISTVO} ">데이터가 없습니다.</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>IO_SEQ</th>
					<th>날자</th>
					<th>매입or매출</th>
					<th>거래처코드</th>
					<th>거래처명</th>
					<th>거래처대표</th>
					<th>상품코드</th>
					<th>상품이름</th>
					<th>매입가격</th>
					<th>판매가격</th>
					<th>부가세여부</th>
					<th>수량</th>
					<th>IO_PRICE</th>
					<th>IO_TOTAL</th>
				</tr>
				<c:forEach items="${IOLISTVO}" var="vo">
					<tr>
						<td>${vo.io_seq}</td>
						<td>${vo.io_date}</td>
						<td>${vo.io_inout}</td>
						<td>${vo.io_dcode}</td>
						<td>${vo.io_dname}</td>
						<td>${vo.io_dceo}</td>
						<td>${vo.io_pcode}</td>
						<td>${vo.io_pname}</td>
						<td>${vo.io_iprice}</td>
						<td>${vo.io_oprice}</td>
						<td>${vo.io_vat}</td>
						<td>${vo.io_qty}</td>
						<td>${vo.io_price}</td>
						<td>${vo.io_total}</td>
					</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>