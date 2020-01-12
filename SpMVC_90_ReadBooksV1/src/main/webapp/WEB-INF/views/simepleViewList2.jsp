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
		<c:when test="${!empty simepleViewList}">
			<c:forEach items="${simepleViewList}" var="simepleViewVO" varStatus="index">
				<tr>
					<td>${simepleViewVO.m_id }</td>
					<td>${simepleViewVO.b_code }</td>
					<td>${simepleViewVO.b_name }</td>
					<td>${simepleViewVO.rb_date }</td>
					<td>${simepleViewVO.rb_subject }</td>
					<td>${simepleViewVO.tb_star }</td>
					<td>
						<a href="${rootPath}/readbook/viewdetail?rb_seq=${simepleViewVO.rb_seq}
						&b_code=${simepleViewVO.b_code}&m_id=${simepleViewVO.m_id}">
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
</body>
</html>