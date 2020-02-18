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

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<style type="text/css">
.card-header{
white-space: nowrap;
overflow: hidden;
text-overflow: ellipsis;
}
</style>
<script type="text/javascript">
$(function() {
	$.ajax({
		url:"${rootPath}/test",
		type:'GET',
		success:function(result){
			alert(result)
			$("#crawlHtml").append(result)
		}
	})

})
</script>
</head>
<header class="jumbotron text-center">
	<h3>주가표</h3>
</header>
<body class="container-fluid">
<section id="crawlHtml" class="row">
	<p></p>
</section>	
</body>
</html>