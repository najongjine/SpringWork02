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
</head>
<body>
<c:forEach items="${List}" var="vo">
<p>seq: ${vo.t_seq}</p>
<p>title: ${vo.t_title}</p>
<p>content: ${vo.t_content}</p>
</c:forEach>
</body>
</html>