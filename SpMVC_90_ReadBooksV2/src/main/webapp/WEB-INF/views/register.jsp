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
<script type="text/javascript">
$(function() {
	
})
</script>
</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>
<form:form modelAttribute="memberVO" method="post">
<table>
	<tr>
		<td>아이디:</td>
		<td><form:input path="m_id"/></td>
		<form:errors path="m_id" cssClass="error"/>
	</tr>
	
	<tr>
		<td>비밀번호:</td>
		<td><form:input path="password" name="m_password"/></td>
		<form:errors path="m_password" cssClass="error"/>
	</tr>
	<tr>
		<td>비밀번호 재입력:</td>
		<td><input type="password" name="re_password"></td>
	</tr>
	
	<tr>
		<td>
		<a href="${rootPath}/member">
		<button>회원가입</button>
		</a>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>