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
var modal="${MODAL}"
</script>
<script src="${rootPath }/js/detailview.js?ver=2">
</script>

</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>
<section>
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

<section>
<article>
내가 읽은 책의 총 갯수:${totalBooksRead }
</article>
<article>
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
		<c:when test="${!empty memberReadBookBooksViewList}">
			<c:forEach items="${memberReadBookBooksViewList}" var="memberReadBookBooksViewVO" varStatus="index">
				<tr class="readbook" data-rb_seq="${memberReadBookBooksViewVO.rb_seq}" data-rb_mid="${memberReadBookBooksViewVO.rb_mid}">
					<td>${memberReadBookBooksViewVO.rb_mid }</td>
					<td>${memberReadBookBooksViewVO.rb_bcode }</td>
					<td>${memberReadBookBooksViewVO.b_name }</td>
					<td>${memberReadBookBooksViewVO.rb_date }</td>
					<td>${memberReadBookBooksViewVO.rb_subject }</td>
					<td>${memberReadBookBooksViewVO.rb_star }</td>
					<td>
						<a href="${rootPath}/readbook/viewdetail?rb_seq=${memberReadBookBooksViewVO.rb_seq}
						&b_code=${memberReadBookBooksViewVO.rb_bcode}&_m_id=${memberReadBookBooksViewVO.rb_mid}">
						<button>상세보기</button>
						</a>
					</td>
				</tr>
			</c:forEach>		
		</c:when>
		<c:otherwise>리스트 없음</c:otherwise>
		</c:choose>
	</table>
</article>
</section>

<section>
	<table>
		<tr>
			<td>
				<a href="${rootPath}/readbook/viewAllBooks"><button>책 목록 보기</button></a>
			</td>
		</tr>
	</table>
</section>

<section>
	<%@ include file="/WEB-INF/views/include/myBookListPagenation.jsp" %>
</section>
</body>
</html>