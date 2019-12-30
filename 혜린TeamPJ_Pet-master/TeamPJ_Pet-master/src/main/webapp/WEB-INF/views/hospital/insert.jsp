<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> 
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>병원정보등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

$(function(){

	
})
</script>
<style>
<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

html {
	height: 100%
}

body {
	overflow-y: auto;
	width: 1200px;
	/* body height를 100으로 설정하려면 html도 height를 같이 맞춰줘야함(html은 height가 기본적으로 없음) */
	height: 100%;
	margin: 0 auto;
}

#head {
	position: relative;
	height: 420px;
}

header {
	margin: 0;
	position: absolute;
	top: 0;
	left: 0;
	z-index: 10;
}

.logo-img {
	position: relative;
	top: 15px;
}

nav {
	margin: 0;
	padding: 0;
	background-color: white;
	color: black;
}

nav ul.main-nav {
	display: flex;
	font-size: 20px;
	list-style: none;
	margin: 0;
	padding: 0;
	justify-content: flex-end;
	position: absolute;
	top: 85px;
	right: 0;
}

nav ul li a {
	margin: 0.3rem;
	display: block;
	color: inherit;
	padding: 14px 16px;
	text-decoration: none;
	transition: 0.5s;
}

nav ul li a:hover {
	padding: 14px 16px 9px 16px;
	border-bottom: 0.2em solid pink;
	font-weight: bold;
}

.bannerimg {
	margin: 0;
	padding: 0;
	position: absolute;
	top: 155px;
	left: 0;
}

#userimg a, #userimg a img {
	display: block;
	position: absolute;
	right: 0;
	top: 5px;
}

	fieldset{
	
		width:70%;
		margin: 50px auto;
		border: 2px solid green;
		border-radius: 5px;
		padding: 2rem;
	}
	
	legend{
		font-weight: bold;
		font-size: 20px;
	}
	
	input, textarea{
		display: inline-block;
		width: 90%;
		padding: 8px;
		margin: 5px;
		border-radius: 20px;
	}
	
	input:focus, textarear:focus {
	
		border: 2px solid black;
		outline: none;
		
	}
	
	#btn{
		width: 100%;
		text-align: center;
		padding: 0.8rem;
	}
	
	#btn-save, #btn-return{
		display: inline-block;
		justify-content: center;
		width: 60px;
		border-radius: 8px;
		padding: 0.5rem;
		font-size: 13px;
		border: 1.5px solid gray;
	}
	#btn-save:hover, #btn-return:hover{
		background-color: lightgray;
		font-weight: bold;
	}
</style>
</head>
<body>

	<div id="head">
		<header>
			<a class="logo-img" href="http://192.168.123.29:8080/pets/"><img
				src="${rootPath}/images/logo.png" width=200 alt="로고이미지"></a>
		</header>

		<div id="userimg">
			<p>
				<a href="${rootPath}/member/login"><img
					src="${rootPath}/images/userimg.png" width=62 alt="유저이미지"></a>
			</p>
		</div>
		<nav>
			<ul class="main-nav">
				<li><a href="http://192.168.123.29:8080/pets/info">소개</a></li>
				<li><a href="${rootPath}/">병원찾기</a></li>
				<li><a href="http://192.168.123.18:8080/pet/bloodtest/allList">피검사</a></li>
				<li><a href="http://192.168.123.18:8080/pet/simplediag/main">상태보고서</a></li>
				<li><a href="http://192.168.123.29:8080/pets/community/list">커뮤니티</a></li>
			</ul>
		</nav>
		<img class="bannerimg" src="${rootPath}/images/insert-banner.png" width=100% alt="배너이미지">
	</div>
<fieldset>
	<legend>병원정보추가</legend>
<form:form modelAttribute="hDTO" autocomplete="on" class="memo-form">
<input name="h_seq" type="hidden" value="<c:out value="${hDTO.h_seq}" default="0"/>">
	<form:input path="h_name" class="in-box" id="h_name" placeholder="병원 이름"/><br/>
	<form:input path="h_addr" class="in-box" id="h_addr" placeholder="병원 주소"/><br/>
	<form:input path="h_tel" class="in-box" placeholder="병원 전화번호"/><br/>
	<form:input path="h_etc" rows="5" class="in-box" placeholder="기타동물"/><br/>
	<form:input path="h_price" class="in-box" placeholder="가격대"/><br/>
	<div id="btn">
	<button id="btn-save">저장</button>
	<button id="btn-return" onclick="location.href='#'">취소</button>
	</div>
</form:form>
</fieldset>

	<footer>
		<%@ include file="/WEB-INF/views/footer.jsp"%>
	</footer>
</body>
</html>