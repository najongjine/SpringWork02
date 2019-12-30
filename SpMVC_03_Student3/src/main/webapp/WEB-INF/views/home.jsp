<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-title.jspf"%>
</head>
<body>
	<%@ include file='/WEB-INF/views/include/include-header.jspf'%>
	<c:choose>
		<c:when test="${BODY=='STUDENT-LIST' }">
			<%@ include file="/WEB-INF/views/body/student/list.jsp"%>
		</c:when>
		<c:when test="${BODY=='DEPT-LIST' }">
			<p> dept.jsp</p>
		</c:when>
		<c:when test="${BODY=='LOGIN' }">
			<p> login.jsp</p>
		</c:when>
		<c:when test="${BODY=='JOIN' }">
			<p> join.jsp</p>
		</c:when>
		<c:otherwise>
			<p>home.jsp</p>
		</c:otherwise>
	</c:choose>

</body>
</html>