<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>all friend list</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>

<%@ include file="/WEB-INF/views/friend/include-nav.jsp" %>
<body>
<section>
<form method="get">
<label for="searchOption">검색</label>
<!--  httpSession을 활용해서 검색후 pagination을 유지하기 위해서
검색한 단어는 get으로 보냄
 -->
<select name="searchOption">
    <option value="nameSearch">이름으로 검색</option>
</select>
<input name="inputStr">
<button>검색</button>
</form>
</section>

<c:if test="${debug=='true' }">
	<section id="debug">
	<p>search option: ${searchVO.searchOption }</p>
	<p>input str: ${searchVO.inputStr }</p>
	</section>
</c:if>


<section>
	<table>
		<tr>
			<th>이름</th>
			<th>전화번호</th>
			<th>주소</th>
			<th>관계</th>
		</tr>
		
		<c:forEach items="${friendList}" var="fVO" varStatus="index">
			<tr>
				<td>${fVO.f_name }</td>
				<td>${fVO.f_phone }</td>
				<td>${fVO.f_address }</td>
				<td>${fVO.f_relation }</td>
				<td>
				<a href="${rootPath }/friend/viewDetail?f_id=${fVO.f_id}">
				<button type="button">상세보기</button>
				</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</section>
<section>
<p><a href="${rootPath}/friend/insert"><button type="button">추가</button></a></p>
</section>

<section>
<%@ include file="/WEB-INF/views/friend/showAllPagenation.jsp" %>
</section>
</body>
</html>