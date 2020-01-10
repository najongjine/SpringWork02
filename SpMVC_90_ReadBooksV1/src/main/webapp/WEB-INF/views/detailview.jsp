<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var rootPath="${pageContext.request.contextPath }"
var memberVO_m_id="${memberVO.m_id}"
var modal="${MODAL}"
</script>
<script src="${rootPath }/js/detailview.js?ver=2"></script>

</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>
<section id="update_modal">
	<c:if test="${MODAL=='UPDATE' }">
	<%@include file="/WEB-INF/views/alterReadBook.jsp" %>
	</c:if>
</section>
<section id="updateForm">
</section>
<section>
	<table border="1">
		<tr>
			<td><label>유저:</label></td>
			<td>${detailBookViewVO.m_id}</td>
		</tr>
		<tr>
			<td><label>책코드</label></td>
			<td>${detailBookViewVO.b_code}</td>
		</tr>
		<tr>
			<td><label>책이름</label></td>
			<td>${detailBookViewVO.b_name}</td>
		</tr>
		<tr>
			<td><label>저자</label></td>
			<td>${detailBookViewVO.b_auther}</td>
		</tr>
		<tr>
			<td><label>출판사</label></td>
			<td>${detailBookViewVO.b_comp}</td>
		</tr>
		<tr>
			<td><label>출판년도</label></td>
			<td>${detailBookViewVO.b_year}</td>
			<td>
			<c:choose>
				<c:when test="${memberVO.m_id == detailBookViewVO.m_id}">
				<a href="${rootPath}/alter/deleteBook?_b_code=${detailBookViewVO.b_code}"><button>책 삭제
				</button>
				</c:when>
			</c:choose>
			</a>
			</td>
		</tr>
	</table>
</section>
	<table border="1">
		<tr>
			<th>일련번호</th>
			<th>도서코드</th>
			<th>독서일자</th>
			<th>독서시작시각</th>
			<th>독서시간</th>
			<th>한줄소감</th>
			<th>긴줄소감</th>
			<th>독서느낌(별점)</th>
		</tr>
		<c:forEach items="${detailBookViewVO.readBookList}" var="readBookVO">
		<tr class="readbook" data-rb_seq="${readBookVO.rb_seq}" data-m_id="${detailBookViewVO.m_id}" }>
			<td>${readBookVO.rb_seq}</td>
			<td>${readBookVO.rb_bcode}</td>
			<td>${readBookVO.rb_date}</td>
			<td>${readBookVO.rb_stime}</td>
			<td>${readBookVO.rb_rtime}</td>
			<td>${readBookVO.rb_subject}</td>
			<td>${readBookVO.rb_text}</td>
			<td>${readBookVO.rb_star}</td>
		</tr>
	</c:forEach>
	</table>
	${memberVO.m_id }<br/>${detailBookViewVO.m_id}
</body>
</html>
