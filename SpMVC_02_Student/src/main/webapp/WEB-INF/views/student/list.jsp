<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>□□□ My JSP Page □□□</title>
</head>
<body>
<h3>학생리스트</h3>
<%/*
*/
%>
<c:forEach items="${STD_LIST}" var="std" varStatus="itemNum">
<p>${itemNum.count }, ${itemNum.index }: ${std}
</c:forEach>
</body>
</html>