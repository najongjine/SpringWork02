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
<form action="${rootPath}/readbook/simpleViewList" method="get">
<label for="searchOption">검색</label>
<!--  httpSession을 활용해서 검색후 pagination을 유지하기 위해서
검색한 단어는 get으로 보냄
 -->
<select name="searchOption">
    <option value="bnameSearch">책이름으로 검색</option>
    <option value="bcodeSearch">책코드로 검색</option>
</select>
<input name="inputStr">
<button>검색</button>
</form>
</section>

<!-- tbl_book + tbl_read_book 을 조인한 리스트를 보여줌
tbl_read_book 데이터가 중점적으로 보여짐 -->
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
		<c:when test="${!empty bookReadBookViewList}">
			<c:forEach items="${bookReadBookViewList}" var="bookReadBookViewVO" varStatus="index">
				<tr>
					<td>${bookReadBookViewVO.rb_mid }</td>
					<td>${bookReadBookViewVO.rb_bcode }</td>
					<td>${bookReadBookViewVO.b_name }</td>
					<td>${bookReadBookViewVO.rb_date }</td>
					<td>${bookReadBookViewVO.rb_subject }</td>
					<td>${bookReadBookViewVO.rb_star }</td>
					<td>
						<a href="${rootPath}/readbook/viewdetail?rb_seq=${bookReadBookViewVO.rb_seq}
						&_m_id=${bookReadBookViewVO.rb_mid}">
						<button>상세보기</button>
						</a>
					</td>
				</tr>
			</c:forEach>		
		</c:when>
		<c:otherwise>리스트 없음</c:otherwise>
		</c:choose>
	</table>
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
	<%@ include file="/WEB-INF/views/include/simViewListPagenation.jsp" %>
</section>
</body>
</html>