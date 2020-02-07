<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<h1>Friend</h1>
<nav class="container">
<ul class="nav">
    <li class="nav-item">
      <a class="nav-link" href="${rootPath }/friend/showAll">메인화면</a>
    </li>
    
    <c:choose>
    	<c:when test="${memberVO==null}">
    	<li class="nav-item">
    		<a class="nav-link" href="${rootPath }/member/login">로그인</a>
    	</li>
    	<li class="nav-item">
    		<a class="nav-link" href="${rootPath }/member/register">회원가입</a>
    	</li>
    	</c:when>
    	<c:otherwise>
    	<li class="nav-item">
    		<a class="nav-link" href="${rootPath }/member/logout">유저: ${memberVO.m_username }</a>
    	</li>
    	</c:otherwise>
    </c:choose>
</ul>
</nav>
