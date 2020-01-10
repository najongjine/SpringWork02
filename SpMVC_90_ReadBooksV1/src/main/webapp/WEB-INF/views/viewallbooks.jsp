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
	<table border=1>
		<tr>
		<th>도서코드</th>
		<th>도서명</th>
		<th>저자</th>
		</tr>
		<c:forEach items="${booksList}" var="booksVO" varStatus="index">
			<tr>
				<td>${booksVO.b_code }</td>
				<td>${booksVO.b_name }</td>
				<td>${booksVO.b_auther }</td>
				<td>
				<a href="${rootPath}/alter/psersonReadBook?_b_code=${booksVO.b_code }">
				<button type="button">읽기</button>
				</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</section>
</body>
</html>