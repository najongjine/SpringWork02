<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/*
index.jsp:= 도메인 네임을 브라우저에 입력하고 enter를 눌렀을때 최초로 보여지는 화면을 index 화면이라고 하고
이때 index 하면을 구현한 파일들이 
static 방식:=index.html,index.htm  문서파일 형태로 화면을 구현함. 누구에게나 거의 유사한 화면을 보여줌.
  
dynamic:=index.php,index.asp,index.jsp  DB,App과 연동되어서 사용자의 요구사항에 따라 화면을
  다르게 보여주는 능동적 방식.
  
index page를 만든다. 화면구현엣거 최초로 만들게 되는 화면.
*/
String strName=request.getParameter("strName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>나(<%=strName %>)의 hp</h3>
<p>wlecome</p>
<p><a href="https://naver.com/">네이버</a>
<p><a href="https://daum.net/">다음</a>
<p><a href="https://google.com/">google</a>
<p><a href="http://localhost:8080/JSP02_Hello/page.jsp?strName=<%=strName%>">나의정보</a>
<p><a href="/JSP02_Hello/page.jsp?strName=<%=strName%>">나의정보</a>
<p><a href="/JSP02_Hello/mypage/mypage1.jsp?strName=성춘향&num1=40&num2=50">성춘향의정보</a>

</body>
</html>