<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String strName="대한민국";
/*
request: jsp 에서만 사용 가능한 java의 singleton static 객체이다.
이미 jsp파일이 만들어지면서 객체생성,초기화까지 완료된 상태.
웹페이지에서 query를 보내면 그 정보를 받을때 사용하는 객체.
*/
strName=request.getParameter("strName");
String strNum1=request.getParameter("num1");
String strNum2=request.getParameter("num2");
int intNum1=Integer.valueOf(strNum1);
int intNum2=Integer.valueOf(strNum2);
int sum=intNum1+intNum2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my page</title>
</head>
<body>
<h3>my page</h3>
<p><%=intNum1 %> +<%=intNum2 %>=<%=sum %></p>
<p>my pae에 오신것을 환영합니다.</p>
<p>jsp test를 위해 작성하고 있습니다.</p>
<!-- space는 한개만 인식 -->
<p>나는                      우리나라</p>
<p>htnl 특수코드로 빈칸 &nbsp;&nbsp;&nbsp;&nbsp;많이 넣기</p>
<p><%=strName %>
<p>Copy Right&copy; callor@callor.com</p>
</body>
</html>