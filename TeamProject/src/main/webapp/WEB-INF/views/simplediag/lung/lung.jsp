<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ lung page □□□</title>
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
<script src="${rootPath}/js/simplediag/lung/simplediag-lung-list.js"></script>
<script>
var rootPath="${pageContext.request.contextPath}"
</script>
<link rel="stylesheet" type="text/css" href="${rootPath }/css/simplediag/lung/lunglist.css?ver=1">
<link rel="stylesheet" type="text/css" href="${rootPath }/css/home.css?ver=3">
<link rel="stylesheet" type="text/css" href="${rootPath }/css/info.css?ver=3">
<link rel="stylesheet" type="text/css" href="${rootPath }/css/community.css?ver=3">
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf" %>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>
<p/>
<%@ include file="/WEB-INF/views/simplediag/lung/lung-body.jspf" %>
<%@ include file="/WEB-INF/views/simplediag/lung/pagenation.jsp" %>
<p/>
<%@ include file="/WEB-INF/views/include/include-footer.jspf" %>
</body>
</html>