<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//java scriptlet(!=javascript)
String strName=request.getParameter("strName");
String strNum1=request.getParameter("num1");
String strNum2=request.getParameter("num2");

int intNum1=0;
int intNum2=0;
try{
	intNum1=Integer.valueOf(strNum1);
	intNum2=Integer.valueOf(strNum2);
}catch(Exception e){
	
}

int intSum=intNum1+intNum2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="http://localhost:8080/JSP01_Hello/home/home1.jsp">
<p><label>num1 </label><input name="num1">
<p><label>num2 </label><input name="num2">
<p><button>계산</button>
</form>
<h3><%=intSum %></h3>
</body>
</html>
