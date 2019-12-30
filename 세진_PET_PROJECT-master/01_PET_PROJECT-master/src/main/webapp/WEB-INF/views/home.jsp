<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>우리 애를 부탁해</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="${rootPath}/js/swiper.min.js?ver=20191229001"></script>
<link rel="stylesheet" href="${rootPath}/css/swiper.min.css?ver=20191228002" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191228001" type="text/css">
<script>
$(function() {
	
	var swiper = new Swiper('.swiper-container', {
		pagination: {
			el: '.swiper-pagination',
		    type: 'progressbar'
		},
		navigation: {
			nextEl: '.swiper-button-next',
		    prevEl: '.swiper-button-prev'
		}
	})
		
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<%@ include file="/WEB-INF/views/include/include-main.jspf" %>
<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>