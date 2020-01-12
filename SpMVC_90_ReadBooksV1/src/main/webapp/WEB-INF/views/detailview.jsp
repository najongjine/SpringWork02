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
<script src="${rootPath }/js/insertBookAjx.js?ver=2"></script>
<script src="${rootPath }/js/alterReadBook.js?ver=2"></script>

</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>
<!-- 이거 안먹음 -->
<section id="update_modal">
	<c:if test="${MODAL=='UPDATE' }">
	<%@include file="/WEB-INF/views/alterReadBook.jsp" %>
	</c:if>
</section>

<section id="updateForm">
</section>
<section id="insertBookForm">
</section>

<section>
	<table border="1">
		<tr>
			<td><label>유저:</label></td>
			<td>${memberReadBookBooksViewVO.rb_mid}</td>
		</tr>
		<tr>
			<td><label>책코드</label></td>
			<td>${memberReadBookBooksViewVO.rb_bcode}</td>
		</tr>
		<tr>
			<td><label>책이름</label></td>
			<td>${memberReadBookBooksViewVO.b_name}</td>
		</tr>
		<tr>
			<td><label>저자</label></td>
			<td>${memberReadBookBooksViewVO.b_auther}</td>
		</tr>
		<tr>
			<td><label>출판사</label></td>
			<td>${memberReadBookBooksViewVO.b_comp}</td>
		</tr>
		<tr>
			<td><label>출판년도</label></td>
			<td>${memberReadBookBooksViewVO.b_year}</td>
			<td>
				<button type="button" id="deleteBook" data-b_code="${memberReadBookBooksViewVO.rb_bcode}">
				책 삭제
				</button>
			</td>
			<td><button type="button" id="insertBook">책 추가</button></td>
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
		<tr class="readbook" data-rb_seq="${memberReadBookBooksViewVO.rb_seq}" data-rb_mid="${memberReadBookBooksViewVO.rb_mid}" }>
			<td>${memberReadBookBooksViewVO.rb_seq}</td>
			<td>${memberReadBookBooksViewVO.rb_bcode}</td>
			<td>${memberReadBookBooksViewVO.rb_date}</td>
			<td>${memberReadBookBooksViewVO.rb_stime}</td>
			<td>${memberReadBookBooksViewVO.rb_rtime}</td>
			<td>${memberReadBookBooksViewVO.rb_subject}</td>
			<td>${memberReadBookBooksViewVO.rb_text}</td>
			<td>${memberReadBookBooksViewVO.rb_star}</td>
		</tr>
	</table>
</body>
</html>
