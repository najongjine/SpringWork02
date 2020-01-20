<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
</head>
<body>
<c:forEach items="testList" var="vo">
<p>${vo.t_seq }</p>
<p>${vo.t_title }</p>
<p>${vo.t_content }</p>
</c:forEach>
</body>
</html>