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
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191228001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/info.css?ver=20191228001" type="text/css">
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<section id="lee-info">
	<h5>INFO</h5>
	
	<strong>평범한 일상도,</strong>
	<strong>특별한 일상도,</strong>
	<strong>함께하는 반려동물</strong>
 
	<p><img src="${rootPath}/images/lee-info-01.png" alt="산책하는강아지"></p>


	<span>저희 < 우리 애를 부탁해 > 는<br/>
	반려동물들을 위한 사이트 입니다.</span>

	<p>집에서 가까운 병원 찾기, 내 반려동물의 피검사 결과,<br/>
	현재 상태 등을 기존보다 조금 더 편리하게 알아 볼 수 있고,<br/>
	동물병원에 대한 이용 후기 등을 통해서<br/>
	다양한 정보를 얻을 수 있습니다.</p>

	<p>현재 10가구 중 1가구에서 반려동물과 함께 살아가고 있습니다.<br/>
	< 우리 애를 부탁해 > 를 통해서<br/>
	반려동물에게 더 많은 관심 부탁드립니다.</p>
</section>

<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>