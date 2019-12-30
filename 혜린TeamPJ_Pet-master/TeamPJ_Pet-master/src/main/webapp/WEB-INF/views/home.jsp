<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>병원찾기</title>
<link rel="stylesheet" href="${rootPath}/css/main.css?ver=20191224001" type="text/css">
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
		<img class="bannerimg" src="${rootPath}/images/main-banner.png" width=100%
			alt="배너이미지">
	</div>

	<section id="main-section-body">
	
			<!-- 지역 선택가능한 dropmenu -->
		<aside>
			<%@ include file="/WEB-INF/views/dropmenu.jsp"%>
		</aside>
	
	<div class="hos-list">
		<article class="hospitallist">
			<div id="h-list"><%@ include file="/WEB-INF/views/hospital/hlist.jsp"%></div>
		</article>
	</div>	
	
	</section>
	<!--  footer -->
	<footer>
		<%@ include file="/WEB-INF/views/footer.jsp"%>
	</footer>

</body>

</html>