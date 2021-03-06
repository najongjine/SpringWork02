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
<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<script type="text/javascript" src="${rootPath }/js/summernote-ko-KR.min.js"></script>

<style type="text/css">
	body{
		border:1px solid #aaa;
	}
</style>

<script type="text/javascript">
$(function() {
	$("#btn-write").click(function() {
		document.location.href="${rootPath}/bbs/input"
	})
	
	var toolbar=[
		['style',['bold','italic','underline']],
		['fontsize',['fontsize']],
		['font Style',['fontname']],
		['color',['color']],
		['para',['ul','ol','paragraph']],
		['height',['height']],
		['table',['table']],
		['insert',['link','hr','picture']],
		['view',['fullscreen','codeview']]
	]
	$("#bbs_content").summernote({
		lang:"ko-KR",
		height:'200px',
		toolbar:toolbar,
		disableDragAndDrop:false
	})
})
</script>
</head>
<header class="jumbotron text-center">
	<h3>Build Board System</h3>
</header>
<ul class="nav">
	<li class="nav-item"><a href="${rootPath }/">Home</a></li>
	<li class="nav-item justify-content-end"><a href="${rootPath}/member/login">Log in</a></li>
	<li class="nav-item"><a href="${rootPath}/member/join">Register</a></li>
</ul>

<body class="container-fluid">
<section>
<c:choose>
	<c:when test="${BODY=='BBS_INPUT' }">
		<%@ include file="/WEB-INF/views/include/bbs_input.jsp" %>
	</c:when>
	<c:when test="${BODY=='VIEW' }">
		<%@ include file="/WEB-INF/views/include/view.jsp" %>
	</c:when>
	<c:otherwise>
		<%@ include file="/WEB-INF/views/include/bbs_list.jsp" %>
		<div class="input-group">
		<div class="input-group-btn">
			<button id="btn-write" class="btn btn-primary" type="button">게시판 작성</button>
		</div>
	</div>
	</c:otherwise>
</c:choose>
</section>
	
</body>
</html>