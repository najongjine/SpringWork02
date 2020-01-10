<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<section>
<table>
<tr>
	<td><a href="${rootPath}/readbook/showalllist">메인화면으로 </a></td>
	<td><a href="${rootPath}/readbook/viewAllBooks">책리스트 </a></td>
	<c:choose>
		<c:when test="${memberVO == null }">
			<td><a href="${rootPath}/member/login">로그인</a></td>
			<td><a href="${rootPath}/member/register">회원가입</a></td>
		</c:when>
	</c:choose>
</tr>
</table>
</section>