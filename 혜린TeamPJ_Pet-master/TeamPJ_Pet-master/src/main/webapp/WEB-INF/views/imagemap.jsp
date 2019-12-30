<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js">
</script>
<script>
	$(function() {

		$(".map-areas area").mouseenter(function() {
			var idx = $(".map-areas area").index(this);
			$(".map-hovers img:eq(" + idx + ")").show();
			return false;
		}).mouseleave(function() {
			$(".map-hovers img").hide();
			return false;
		});

	});
</script>
</head>
<style>
#container img {
	display: block;
	z-index: -4;
	position: relative;
}

.map-hovers #seoul {
	position: absolute;
	top: 520.7px;
	left: 220.5px;
	display: block;
}

.map-hovers #gwangju {
	position: absolute;
	top: 834.5px;
	left: 211px;
	display: block;
	z-index: 3;
}

.map-hovers #jeonam {
	position: absolute;
	top: 809px;
	left: 127px;
	display: block;
	z-index: 1;
}
</style>
<body>

<div id="container">
	<img src="${rootPath}/images/map/korea.png" class="map-trains" alt="한국지도" usemap="#image-map" />
</div>
		<div class="map-hovers">
			<img src="${rootPath}/images/map/gwangju.png" alt="광주" id="gwangju"/>
			<img src="${rootPath}/images/map/jeonam.png" alt="전남" id="jeonam"/>
			<img src="${rootPath}/images/map/seoul.png" alt="서울"id="seoul"/>
		</div>

	
	<map name="image-map" id="image-map" class="map-areas">
		<area target="_self" shape="poly" coords="108,413,97,420,102,432,101,443,127,440,119,420" href="#" alt="광주"/>
		<area target="_self" shape="poly" coords="61,398,34,419,18,458,14,540,63,549,100,533,142,538,194,517,212,488,210,441,187,406,145,413,111,386,88,419,76,415,78,402" href="#" alt="전남">
		<area target="_self" shape="poly" coords="115,100,105,109,118,123,132,132,146,107,138,104,128,100" href="#" alt="서울">
	</map>
	
</body>
</html>