<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>view a data</title>
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script> 
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	var rootPath = "${pageContext.request.contextPath }"
</script>
<script src="${rootPath }/js/bld-findByNameAndValue.js"></script>

<link rel="stylesheet" type="text/css" href="${rootPath }/css/home.css?ver=2">
<link rel="stylesheet" type="text/css" href="${rootPath }/css/info.css?ver=2">
<link rel="stylesheet" type="text/css" href="${rootPath }/css/community.css?ver=2">
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<p/>
	<%@ include file="/WEB-INF/views/bloodtest/findByNameAndValue-body.jspf" %>
	<p/>
	<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>