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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#regisButton").click(function() {
		let pass=$("#m_password").val()
		let repass=$("#re_password").val()
		if(pass!=repass){
			alert("비번 입력이 서로 다릅니다")
			return false
		}
		$("#formRegister").submit()
	})
})
</script>
</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>
<form:form modelAttribute="memberVO" method="post" id="formRegister">
<table>
	<tr>
		<td>아이디:</td>
		<td><form:input path="m_id"/>
		<form:errors path="m_id" /></td>
	</tr>
	
	<tr>
		<td>비밀번호:</td>
		<td><form:input type="password" id="m_password" path="m_password"/>
		<form:errors path="m_password" /></td>
	</tr>
	<tr>
		<td>비밀번호 재입력:</td>
		<td><input type="password" id="re_password" name="re_password"></td>
	</tr>
	
	<tr>
		<td>
		<button type="button" id="regisButton">회원가입</button>
		</td>
	</tr>
</table>
</form:form>
</body>
</html>