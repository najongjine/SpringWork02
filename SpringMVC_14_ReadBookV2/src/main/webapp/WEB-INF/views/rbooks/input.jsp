<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link href="${rootPath}/css/rbook-main.css?ver=2020-01-14-001" rel="stylesheet" type="text/css">
<link href="${rootPath}/css/main-table.css?ver=2020-01-14-001" rel="stylesheet" type="text/css">
<link href="${rootPath}/css/color.css?ver=2020-01-14-001" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function() {
	$("#btn-write").click( ()=> {
		document.location.href="${rootPath}/book/write"
	})
})
</script>
</head>
<body>
<header>
	<h2>My Read Book</h2>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>


<section id="main-writer">
	<article>
		<form:form action="" modelAttribute="rBookVO">
			<form:input type="text" path="rb_bcode" placeholder="도서코드"/><br/>
			<form:input type="text" path="rb_date" placeholder="독서일자"/><br/>
			<form:input type="text" path="rb_stime" placeholder="독서시작시간"/><br/>
			<form:input type="text" path="rb_rtime" placeholder="독서시간"/><br/>
			<form:input type="text" path="rb_subject" placeholder="한줄평"/><br/>
			<form:input type="text" path="rb_star" placeholder="별점"/><br/>
			<form:textarea path="rb_text" placeholder="독서소감"></form:textarea><br/>
			
			<div id="main-button">
				<button id="btn-write" class="biz-blue flex-right">독서록 작성</button>
			</div>
		</form:form>
	</article>
	
</section>
</body>
</html>