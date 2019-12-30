<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
aside a, .choose {
	
	text-decoration: none;
	display: block;
	padding: 1rem 1rem;
	color: black;
}
.choose{
	font-weight: bold;
	border-bottom: 2px solid black;
	font-size: 22px;
	color: orange;
}

aside a:hover{
	color: #A2CD0C;
}

aside ul{
	list-style: none;
	margin: 0;
	padding: 0;
	border: 2px solid black;
	border-radius: 5px;
}


.city-main-box{
	text-align: center;
	
}
.politan-main, .city-main {
	position: relative;
	cursor: pointer;
}

.main-letter:hover {
	font-weight: bold;
}
.politan-sub, .city-sub {
	cursor: pointer;
	visibility: hidden;
	opacity: 0;
	position: absolute;
	left: 0;
	width: 100%;
	z-index: -1;
	transform: translateY(-2rem);
	transition: all 0.3s ease-in-out, visibility 0s linear 0.3s,
	z-index 0s linear 0.05s;
	background: #ddd;
	color: black;
}

.politan-main:focus .politan-sub,
.politan-main:hover .politan-sub,
.city-main:focus .city-sub,
.city-main:hover .city-sub{
	
	background-color: #eee;
	visibility: visible;
	opacity: 1;
	z-index: 10;
	transform: translateY(0);
	transition-delay: 0s, 0s, 0.3s;
}

</style>
<body>
	<ul class="city-main-box">
		<li class="choose">지역선택</li>
		<li class="politan-main"><a class="main-letter">특별시 및 광역시</a>
			<ul class="politan-sub">
				<li><a href="#">서울</a></li>
				<li><a href="#">광주</a></li>
				<li><a href="#">대구</a></li>
				<li><a href="#">대전</a></li>
				<li><a href="#">부산</a></li>
				<li><a href="#">울산</a></li>
				<li><a href="#">인천</a></li>
				<li><a href="#">세종</a></li>
			</ul>
		<li class="city-main"><a class="main-letter">기타 시/도/군</a>
			<ul class="city-sub">
				<li><a href="#">전라남도</a></li>
				<li><a href="#">전라북도</a></li>
				<li><a href="#">경상남도</a></li>
				<li><a href="#">경상북도</a></li>
				<li><a href="#">충청남도</a></li>
				<li><a href="#">충청북도</a></li>
				<li><a href="#">경기도</a></li>
				<li><a href="#">강원도</a></li>
				<li><a href="#">제주도</a></li>
			</ul></li>
		</li>
	</ul>
</body>
</html>