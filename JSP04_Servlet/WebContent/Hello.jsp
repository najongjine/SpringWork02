<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String st_name=request.getParameter("strName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/JSP04_Servlet/hello">
<label>이름: </label><input name="strName">
<label>학과: </label><input name="st_dept">
<label>학년: </label><input name="st_grade">
<button>전송</button>
</form>
</body>
</html>