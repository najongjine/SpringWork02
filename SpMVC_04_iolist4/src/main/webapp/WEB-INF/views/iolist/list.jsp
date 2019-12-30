<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<link href="${rootPath }/css/list-table.css?ver=1" rel="stylesheet"
	type="text/css">
<link href="${rootPath }/css/top-scroll.css?ver=1" rel="stylesheet"
	type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
p#insert {
	margin-left: 40px;
}

article.body {
	width: 95%;
	overflow: auto;
	margin: 10px auto;
}
</style>
<script>
	$(function() {
		$(".content-body").click(function(e) {
			let id = $(this).attr("data-id")
			let name = $(this).attr("data-name")
			
			/*
			주소창에 /dept/view를 입력하여 서버에 전송하라
			id변수에 값을실어서 보내라
			 */
			document.location.href = "${rootPath}/iolist/view?id=" + id
		})
		var preScroll = $(window).scrollTop();
		$(window).scroll(function(e) {
			let curScroll = $(window).scrollTop();
			if (preScroll > curScroll) {
				$("ul.main-menu").css("top", 0)
			} else {
				$("ul.main-menu").css("top", -80)
			}
			preScroll = curScroll
		})
	})
</script>

</head>
<body>

	<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>
	<section class="dept">
		<article>
			<p id="insert">
				<a href="${rootPath }/iolist/insert"><button>새로등록</button></a>
		</article>
		<article class="body">
			<table>
				<tr>
					<th>NO</th>
					<th>거래일자</th>
					<th>구분</th>
					<th>CD</th>
					<th>거래처명</th>
					<th>대표자명</th>
					<th>CD</th>
					<th>상품명</th>
					<th>매입단가</th>
					<th>매출단가</th>
					<th>부가세</th>
					<th>수량</th>
					<th>단가</th>
					<th>금액</th>
				</tr>
				<c:choose>
					<c:when test="${empty IOLIST }">
						<tr>
							<td>데이터가 없음</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${IOLIST }" var="dto" varStatus="info">
						<%
						/*tag에 포함할수 있는 속성은 id, class만 있다.
						html5 에서는 사용자 정의형 속성을 만들수 있다.
						data-*
						JQ에서 참조가능
						*/
						%>
							<tr class="content-body" data-id="${dto.io_seq}" data-name="aaa">
								<td>${dto.io_seq}</td>
								<td>${dto.io_date}</td>
								<td>${dto.io_inout}</td>
								<td>${dto.io_dcode}</td>
								<td>${dto.io_dname}</td>
								<td>${dto.io_dceo}</td>
								<td>${dto.io_pcode}</td>
								<td>${dto.io_pname}</td>
								<td>${dto.io_iprice}</td>
								<td>${dto.io_oprice}</td>
								<td>${dto.io_vat}</td>
								<td>${dto.io_qty}</td>
								<td>${dto.io_price}</td>
								<td>${dto.io_total}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
		</article>
	</section>
</body>
</html>