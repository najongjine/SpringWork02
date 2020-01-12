<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
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
<form:form modelAttribute="memberVO" method="post">
<table>
	<tr>
		<td>아이디:</td>
		<td><input name="m_id"></td>
	</tr>
	
	<tr>
		<td>비밀번호:</td>
		<td><input type="password" name="m_password"></td>
	</tr>
	
	<tr>
		<td><button>로그인</button></td>
		<td>
		<a href="${rootPath}/member/register">
		<button>회원가입</button>
		</a>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>