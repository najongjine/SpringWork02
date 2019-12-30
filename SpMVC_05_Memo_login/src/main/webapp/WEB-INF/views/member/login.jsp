<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<link rel="stylesheet" type="text/css"
	href="${rootPath}/css/login.css?ver=1" />
</head>
<body>
	<form method="POST" class="login-form">
		<h2>login</h2>
		<c:if test="${LOGIN_MSG == 'TRY' }">
			<h3>로그인을 해야 합니다</h3>
		</c:if>
		<c:if test="${LOGIN_MSG == 'NO_AUTH' }">
			<h3>작성자만 볼수있음!!!</h3>
		</c:if>
		<input type="text" name="u_id" placeholder="사용자 ID"> <input
			type="password" name="u_password" placeholder="비밀번호">
		<button>login</button>
		<c:if test="${LOGIN_MSG == '0' }">
			<button>회원가입</button>
		</c:if>
	</form>
</body>
</html>