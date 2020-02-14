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
var memberVO_m_id="${memberVO.m_id}"
</script>
<script src="${rootPath }/js/updateBookAjx.js?ver=3"></script>
<script src="${rootPath }/js/insertBookAjx.js?ver=2"></script>
<script src="${rootPath }/js/deleteBook.js?ver=2"></script>


</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>

<form method="get">
<label for="searchOption">검색</label>

<select name="searchOption">
    <option value="bnameSearch">책이름으로 검색</option>
    <option value="bcodeSearch">책코드로 검색</option>
</select>
<input name="inputStr">
<button>검색</button>
</form>
</section>

<section id="updateBookForm">
</section>
<section id="insertBookForm">
</section>

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
				<a href="${rootPath}/alter/insertReadBook?_b_code=${booksVO.b_code }">
				<button type="button">읽기</button>
				</a>
				</td>
				<td><button id="updateBook" type="button"
				data-b_code="${booksVO.b_code}">수정</button>
				</td>
				<td>
				<button type="button" id="deleteBook" data-b_code="${booksVO.b_code }">
				책 삭제
				</button>
			</td>
			</tr>
		</c:forEach>
	</table>
</section>
<section>
	<article>
		<td><button type="button" id="insertBook">책 추가</button></td>
	</article>
</section>

<section>
	<%@ include file="/WEB-INF/views/include/viewAllBooksPagenation.jsp" %>
</section>
</body>
</html>