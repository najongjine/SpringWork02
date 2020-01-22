<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("textarea").click(function() {
		$("#a1").toggle()
	})
})
</script>
</head>
<body>
<form method="post">
	<p>title:<input name="t_title"></p>
	<p>content:<textarea id="a1" name="t_content" placeholder="type here" style="width: 100%;"></textarea> </p>
	<button>save</button>
</form>
<%@ include file="/WEB-INF/views/286chatbot.jspf" %>
</body>
</html>