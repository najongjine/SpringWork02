<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="${rootPath}/css/login.css?ver=201912170468" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<script>
	
	$(function(){
		
		$(".txtb input").on("focus", function() {
			$(this).addClass("focus")
		})

		$(".txtb input").on("blur", function() {
			if ($(this).val() == "")
				$(this).removeClass("focus")
		})
		
	})
	
</script>

</head>


<body>

<div id="back-img">
	<img src="${rootPath}/images/login-background.jpg">
</div>

<div id="back-color">
	
</div>


	<form method="POST" action="${rootPath}/member/login" class="login-form">
		<h1>Login</h1>
		
		<c:if test="${LOGIN_MSG == 'FAIL'}">
			<h3>아이디 혹은 비밀번호를 다시 확인하시고 입력해주세요</h3>
		</c:if>
		
		<c:if test="${LOGIN_MSG == 'TRY'}">
			<h3>login required</h3>
		</c:if>

		<div class="txtb">
			<input type="text"> <span data-placeholder="UserID"></span>
		</div>

		<div class="txtb">
			<input type="password"> <span data-placeholder="Password"></span>
		</div>
		
		<button type="button" onclick="location.href='#'" id="logbtn">Login</button>

		<div class="bottom-text">
			<p>Don't have account?
			<a id="signup-text" href="${rootPath}/member/join">Sign up here</a>
			</p>
		</div>
	</form>
</body>
</html>
