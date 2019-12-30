<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="${rootPath }/js/jquery-3.4.1.js"></script>
<script>
	$(function() {
		$("#btn-insert").click(function() {
			document.location.href = "${rootPath}/memo/insert"
		})
	})
</script>
<style type="text/css">
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html, body {
	height: 100%;
}

body {
	width: 978px;
	display: flex;
	flex-flow: column nowrap;
	margin: 0 auto;
}

nav ul {
	list-style: none;
	background-color: blue;
	display: flex;
	color: white;
}

nav li:nth-child(2) {
	margin-left: auto;
}

nav li:nth-child(4) {
	margin-left: auto;
}

nav ul a {
	text-decoration: none;
	display: inline-block;
	color: inherit;
	margin: 5px;
	padding: 8px;
}

header {
	background-color: #ccc;
	text-align: center;
	padding: 0.8rem;
}

footer {
	flex: 0 0 auto;
	background: green;
	color: white;
	text-align: center;
	padding: 0.2rem;
	background: green;
}

section#main-body {
	flex-grow: 1;
	flex-shrink: 0;
	flex-basis: auto;
	background-color: #ddd;
	display: flex;
}

section#main-body article {
	flex: 5;
}

section#main-body aside {
	flex: 1;
	border: 1px solid blue;
	background-color: white;
	padding: 16px;
	border-radius: 10px;
}

section#main-body ul {
	list-style: none;
	margin-left: 16px;
}

section#main-body li a {
	display: inline-block;
	width: 100px;
	border-bottom: 1px solid blue;
	padding: 10px 16px;
	text-decoration: none;
	border-bottom: 1px solid blue;
}

section#main-body il a:hover {
	background-color: #ccc;
}

article.list {
	border: 1px solid red;
	height: 90%;
	overflow: auto;
}

div.b-box {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 0.8rem;
}

div.b-box button {
	background-color: orange;
	color: blue;
	font-weight: bold;
	padding: 8px 16px;
	border: 0px;
	border-radius: 5px;
}

div.b-box button:hover {
	background-color: #ddd;
}

div.s-box {
	width: 100% border: 1px solid blue;
	margin-bottom: 5px;
}

div.s-box input {
	display: block;
	margin: 10px auto;
	width: 90%;
}
</style>

</head>
<body>
	<header>
		<h3>Simple Memo</h3>
	</header>

	<nav>
		<ul>
			<li><a href="${rootPath }">home</a></li>
			<li><a href="${rootPath }">menu1</a></li>
			<li><a href="${rootPath }">menu2</a></li>

			<c:if test="${userDTO == null||userDTO.u_id==null }">
				<li><a href="${rootPath }/member/login">login</a></li>
				<li><a href="${rootPath }/user/join">register</a></li>
			</c:if>

			<c:if test="${userDTO != null && userDTO.u_id!=null}">
				<li><a href="${rootPath }/member/logout">logout</a></li>
				<li><a href="${rootPath }/user/mypage">${userDTO.u_nick }</a></li>
			</c:if>
		</ul>
	</nav>
	<section id="main-body">
		<article>
			<div class="s-box">
				<form>
					<input type="text" name="search">
				</form>
			</div>
			<article class="list">
				<c:choose>
					<c:when test="${BODY=='JOIN' }">
						<%@ include file="/WEB-INF/views/user/insert.jsp"%>
					</c:when>
					<c:when test="${BODY=='LOGIN' }">
						<%@ include file="/WEB-INF/views/member/login.jsp"%>
					</c:when>
					<c:when test="${BODY=='MEMO_WR' }">
						<%@ include file="/WEB-INF/views/memo/insert.jsp"%>
					</c:when>
					<c:when test="${BODY=='MEMO_VI' }">
						<%@ include file="/WEB-INF/views/memo/view.jsp"%>
					</c:when>
					<c:otherwise>
						<%@ include file="/WEB-INF/views/memo/list.jsp"%>
					</c:otherwise>
				</c:choose>

			</article>
			<div class="b-box">

				<button id="btn-insert">메모작성</button>
			</div>
		</article>

		<aside>
			<ul>
				<li><a href="#">오늘할일</a></li>
				<li><a href="#">약속</a></li>
				<li><a href="#">중요메모</a></li>
			</ul>
		</aside>
	</section>


	<footer>
		<address>Copy Right &copy; najongjin3@hotmail.com</address>
	</footer>
</body>
</html>