<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String strName=request.getParameter("strName");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>나의 정보</h3>
<p>나는 (<%=strName %>) 입니다</p>
<%out.write("대한"); %>
<%out.write(30*40); %>
<%int sum=30+40; out.write(sum); %>
<p>나는 (<%=strName %>) 입니다</p>
<p>나는 (<%=strName %>) 입니다</p>
</body>
</html>