<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="booksVO">
		<table>
			<tr>
				<td>책코드: </td>
				<td><form:input readonly="true" path="b_code"/></td>
			</tr>
			
			<tr>
				<td>책이름: </td>
				<td><form:input path="b_name"/></td>
			</tr>
			
			<tr>
				<td>저자: </td>
				<td><form:input path="b_auther"/></td>
			</tr>
			
			<tr>
				<td>출판사: </td>
				<td><form:input path="b_comp"/></td>
			</tr>
			
			<tr>
				<td>발행년도: </td>
				<td><form:input path="b_year"/></td>
			</tr>
			
			<tr>
				<td>가격: </td>
				<td><form:input type="number" path="b_iprice"/></td>
			</tr>
			
			<tr>
				<td><button>책 수정</button></td>
			</tr>
		</table>
	</form:form>
</body>
</html>