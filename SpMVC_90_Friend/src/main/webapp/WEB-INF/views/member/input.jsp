<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>register</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

</head>

<%@ include file="/WEB-INF/views/friend/include-nav.jsp"%>
<body>
	<section id="registerForm">
		<c:if test="${mode=='register' }">
			<h3>회원가입</h3>
			<form method="post" action="${rootPath}/member/register">
				<p>
					<label>유저: </label><input name="m_username">
				</p>
				<p>
					<label>비밀번호: </label><input name="m_password" type="password">
				</p>
				<p>
					<button>회원가입</button>
				</p>
			</form>
		</c:if>
		
		<c:if test="${mode=='login' }">
			<h3>로그인</h3>
			<form method="post" action="${rootPath}/member/login">
			<p>
				<label>유저: </label><input name="m_username">
			</p>
			<p>
				<label>비밀번호: </label><input name="m_password" type="password">
			</p>
			<p>
				<button>로그인</button>
			</p>
			</form>
		</c:if>
	</section>

</body>
</html>