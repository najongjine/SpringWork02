<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//HelloServlet 클래스이 doGet method에;서
//sendRedirect 로 보내준 데이터를 추출하여 변수에 담기
String strName=request.getParameter("strName");
String st_dept=request.getParameter("st_dept");
String st_grade=request.getParameter("st_grade");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>학생정보</h3>
<p>이름: <%=strName %></p>
<p>학과: <%=st_dept %></p>
<p>학년: <%=st_grade %></p>
</body>
</html>