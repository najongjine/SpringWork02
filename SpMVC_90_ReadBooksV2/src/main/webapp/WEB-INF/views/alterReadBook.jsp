<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<!-- 
<link rel="stylesheet" href="${rootPath}/css/alterReadBook.css?ver=20191228002" type="text/css">
 -->
 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
var rootPath="${pageContext.request.contextPath }"
var memberVO_m_id="${memberVO.m_id}"
</script>
<script src="${rootPath }/js/alterReadBook.js?ver=3"></script>


</head>
<body>
<header>
	<%@ include file="/WEB-INF/views/include/nav.jsp" %>
</header>
<section class="update-form">
<form:form modelAttribute="readBookVO" action="${rootPath}/alter/updateReadBook" method="post">
	<table>
		<tr>
		<td>m_id:</td>
		<td>
		<input name="_m_id" value="${memberVO.m_id }" readonly="readonly">
		</td>
		</tr>
			<tr>
			<td>일렬번호</td>
			<td>
				<form:input readonly="readonly" path="rb_seq" placeholder="${readBookVO.rb_seq}"/>
			</td>
			</tr>
			
			<tr>
			<td>책코드</td>
			<td>
				<form:input readonly="readonly" path="rb_bcode" placeholder="${readBookVO.rb_bcode}"/>
			</td>
			</tr>
			
			<tr>
			<td>읽은날자</td>
			<td>
				<form:input type="text" path="rb_date" placeholder="${readBookVO.rb_date}"/>
			</td>
			</tr>
			
			<tr>
			<td>읽기 시작시간</td>
			<td>
				<form:input type="text" path="rb_stime" placeholder="${readBookVO.rb_stime}"/>
			</td>
			</tr>
			
			<tr>
			<td>총 읽은시간</td>
			<td>
				<form:input type="text" path="rb_rtime" placeholder="${readBookVO.rb_rtime}"/>
			</td>
			</tr>
			
			<tr>
			<td>한줄소감</td>
			<td>
				<form:input type="text" path="rb_subject" placeholder="${readBookVO.rb_rtime}"/>
			</td>
			</tr>
			
			<tr>
			<td>평가</td>
			<td>
				<form:textarea path="rb_text" />
			</td>
			</tr>
			
			<tr>
			<td>점수</td>
			<td>
				<form:input type="number" path="rb_star" placeholder="${readBookVO.rb_star}"/>
			</td>
			</tr>
			
			<tr>
			<c:choose>
			<c:when test="${MODE=='UPDATE' }">
				<td><button>수정</button></td>
			</c:when>
			<c:otherwise>
				<td><button>책 다 읽음</button></td>
			</c:otherwise>
			</c:choose>
			</tr>
			
			<tr>
				<td>
				<a href="${rootPath}/alter/deleteReadBook?_rb_seq=${readBookVO.rb_seq}">
				<button type="button">삭제</button>
				</a>
				</td>
				
				<td>
					<button type="button" id="postDelete" data-rb_seq="${readBookVO.rb_seq }">삭제(post)</button>
				</td>
			</tr>
	</table>
</form:form>
</section>
</body>
</html>