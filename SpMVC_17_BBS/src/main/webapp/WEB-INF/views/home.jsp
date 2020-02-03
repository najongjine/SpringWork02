<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	body{
		border:1px solid #aaa;
	}
</style>

<script type="text/javascript">
$(function() {
	$("#btn-write").click(function() {
		document.location.href="${rootPath}/bbs/write"
	})
})
</script>
</head>
<header class="jumbotron text-center">
	<h3>Build Board System</h3>
</header>
<ul class="nav">
	<li class="nav-item"><a href="nav-link" href="/">Home</a></li>
	<li class="nav-item justify-content-end"><a href="nav-link" href="/member/login">Log in</a></li>
	<li class="nav-item"><a href="nav-link" href="/member/join">Register</a></li>
</ul>

<body class="container-fluid">
	<div class="input-group">
		<div class="input-group-btn">
			<button id="btn-write" class="btn btn-default" type="button">게시판 작성</button>
		</div>
	</div>
</body>
</html>