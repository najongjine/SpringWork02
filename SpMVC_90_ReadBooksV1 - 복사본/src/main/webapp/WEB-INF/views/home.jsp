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

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var rootPath="${pageContext.request.contextPath }"
</script>
<script src="${rootPath }/js/showAllListHome.js?ver=1"></script>

</head>
<body>
<section>
	<table border="1">
		<tr>
			<th>사용자ID</th>
			<th>도서코드</th>
			<th>도서제목</th>
			<th>독서일자</th>
			<th>한줄소감</th>
			<th>별점</th>
		</tr>
		<c:choose>
		<c:when test="${!empty memberList}">
			<c:forEach items="${memberList}" var="memberVO" varStatus="index">
				<c:forEach items="${memberVO.booksList }" var="booksVO" varStatus="index2">
					<c:forEach items="${booksVO.readBookList }" var="readBookVO" varStatus="index3">
					<tr data-rb_seq="${readBookVO.rb_seq }" class="readBookVOBody"
					data-b_code="${booksVO.b_code}" data-m_id="${memberVO.m_id}">
						<td>${memberVO.m_id}</td>
						<td>${booksVO.b_code}</td>
						<td>${booksVO.b_name}</td>
						<td>${readBookVO.rb_date}</td>
						<td>${readBookVO.rb_subject}</td>
						<td>${readBookVO.rb_star}</td>
					</tr>
					</c:forEach>
				</c:forEach>
				
			</c:forEach>		
		</c:when>
		<c:otherwise>리스트 없음</c:otherwise>
		</c:choose>
	</table>
</section>
</body>
</html>