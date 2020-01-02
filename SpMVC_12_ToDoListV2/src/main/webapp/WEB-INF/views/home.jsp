<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js">
</script>
<script type="text/javascript">
$(function() {
	$("#login").click(function() {
		$("#myModal").css("display","block")
	})
})
</script>
<style type="text/css">
*{
margin: 0;
padding: 0;
box-sizing: border-box;
}
header{
padding: 2rem 1rem;
margin-bottom: 2rem;
background-color: #E9ECEF;
border-radius: 0.3rem;
}
table{
border: 1px solid gray;
border-collapse: collapse;
width: 95%;
margin: 0 auto;
}
table.input tr, table.input td, table.input th{
padding: 10px;
}
table.list tr, table.list td, table.list th{
	border: 1px solid gray;
	padding: 5px;
}
.line-through{
text-decoration: line-through;
}
li#login{
cursor: pointer;
display: inline-block;
padding: 10px 20px;
}
li#login:hover{
background-color: #ddd;
}
</style>
</head>
<nav>
	<ul>
		<li id="login">login</li>
	</ul>
</nav>
<body>
<header>
	<h3>To do List</h3>
</header>

<section>
	<article id="input">
		<form action="" method="post">
			<input type="hidden" name="td_seq" 
			value='<c:out value="${todoDTO.td_seq }" default="0" />'>
			<input type="hidden" name="td_complete" value="${todoDTO.td_complete}">
			<input type="hidden" name="td_date" value="${todoDTO.td_date }">
			<input type="hidden" name="td_time" value="${todoDTO.td_time }">
			<table class="input">
				<tr>
					<td>
					<label for="td_flag">중요도</label>
					<input id="td_flag" type="number" min="1" max="5" name="td_flag" 
					value='<c:out value="${todoDTO.td_flag}" default="1"/>'  >
					</td>
					
					<td>
					<input type="text" name="td_subject" value=""${todoDTO.td_subject }">
					</td>
					
					<td>
					<input type="checkbox" id="td_alarm" name="td_alarm" 
					<c:if test="${todoDTO.td_alarm=='Y'}"> chekced="checked" </c:if> value="Y">
					<label for="td_alarm">알람설정</label>
					</td>
					
					<td>
					<button>저장</button>
					<a href="${rootPath }/">새로작성</a>
					</td>
				</tr>
			</table>
		</form>
	</article>
	
	<article id="list">
		<c:if test="${!empty todoList }">
		<table class="list">
			<tr>
				<th>no</th>
				<th>Flag</th>
				<th>제목</th>
				<th>완성</th>
				<th>알람</th>
				<th>명령</th>
			</tr>
			<c:forEach items="${todoList }" var="todo" varStatus="index">
				<tr>
					<td>${index.count }</td>
					<td>${todo.td_flag }</td>
					<td <c:if test="${todo.td_complete=='Y'}"> class="line-through" </c:if>>
					${todo.td_subject }
					</td>
					<td>
					<a href="${rootPath }/complete?td_seq=${todo.td_seq}&td_complete=${todo.td_complete}">
					${todo.td_complete }
					</a>
					</td>
					<td>
					<a href="${rootPath }/alarm?td_seq=${todo.td_seq}&td_alarm=${todo.td_alarm}">
					${todo.td_alarm }
					</td>
					<td>
					<a href="${rootPath }/update?td_seq=${todo.td_seq}">수정</a>
					<a href="${rootPath }/delete?td_seq=${todo.td_seq}">삭제</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		</c:if>
	</article>
</section>
<%@ include file="/WEB-INF/views/modal-box.jsp" %>
</body>
</html>
