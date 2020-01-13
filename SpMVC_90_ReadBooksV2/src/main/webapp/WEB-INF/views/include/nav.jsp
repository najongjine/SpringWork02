<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<style>
a{
text-decoration: none;
color: white;
}
#nav{
background-color: blue;
}
.navtable{
border-spacing: 10px;
}
section{
margin-top:1.5;
margin-bottom: 1.5%;
}
</style>
<section id="nav">
<table border="1" class="navtable">
<tr>
	<td><a href="${rootPath}/readbook/simpleViewList"> 메인화면으로 </a></td>
	<td></td>
	<td><a href="${rootPath}/readbook/myBookList"> 나의책보기기록 </a></td>
	<td></td>
	<td><a href="${rootPath}/readbook/viewAllBooks"> 책리스트 </a></td>
	<td><br/></td>
	<c:choose>
		<c:when test="${memberVO == null }">
			<td><a href="${rootPath}/member/login"> 로그인</a></td>
			<td></td>
			<td><a href="${rootPath}/member/register"> 회원가입</a></td>
			<td></td>
		</c:when>
		<c:otherwise><td></td><td>
		<a href="${rootPath}/member/logout">
		${memberVO.m_id }
		</a>
		</td><td></td></c:otherwise>
	</c:choose>
</tr>
</table>
</section>