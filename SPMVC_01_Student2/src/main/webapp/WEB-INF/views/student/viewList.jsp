<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학생리스트</h2>
<!-- jstl, core taglib를 사용한 tag 코드를 시작한다 -->
<c:forEach items="${ stdList}" var="dto">
<p>${dto.st_num }:
${dto.st_name }: 
${dto.st_dept }: 
${dto.st_grade }:  
${dto.st_tel }:     
</c:forEach>

</body>
</html>