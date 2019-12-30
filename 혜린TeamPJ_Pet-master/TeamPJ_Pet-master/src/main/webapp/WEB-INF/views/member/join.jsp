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
<link href="${rootPath}/css/join.css?ver=201912170468" rel="stylesheet" type="text/css">
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
		
		#("#btn-sane").click(function(){
			
			let pass = $("#u_password").val()
			if(pass == "")
			
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


	<form:form model Attribute="userDTO" autocomplete="on" action="login.jsp" class="join-form">
		<h1>Join</h1>

		<div class="txtb">
			<form:input path="u_id" type="text"/> <span data-placeholder="UserID"></span>
			<button type="button" id="id_check">아이디검사</button>
			<br />
			
			<form:errors path="u_id" class="in-error" />
			<br /> <span id="u_id_msg"></span>
		</div>
		
		<div class="txtb">
			<form:input path="u_name" type="text"/> <span data-placeholder="UserName"></span>
		</div>

		<div class="txtb">
			<form:input path="u_password" type="password"/> <span data-placeholder="Password"></span>
			<form:errors path="re_password" class="in-error"/>
		</div>
		
		<div class="txtb">
			<form:input path="re_password" type="password"/> <span data-placeholder="Confirm Password"></span>
			<form:errors path="re_password" class="in-error"/>
		</div>
		
		<div class="txtb">
			<form:input  path="u_pname" type="text"/> <span data-placeholder="Pet Name"></span>
			<form:errors path="u_pname" class="in-error"/>
		</div>
		
		<div class="txtb">
			<form:input path="u_page" type="text"/> <span data-placeholder="Pet Age"></span>
		</div>
		
		<div class="txtb">
			<form:input path="u_pweight" type="text"/> <span data-placeholder="Pet weight"></span>
		</div>
		
		<button type="button" id="btn-join">Join</button>

		<div class="bottom-text">
			<p>Need Help?
			<a id="signup-text" href="#">click here</a>
			</p>
		</div>
	</form:form>
</body>
</html>
