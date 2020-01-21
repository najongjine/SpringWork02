<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<script>
$(function() {
	$(".viewButton").click(function() {
		let text=$(this).text()
		let url="${rootPath}/ems/"
		if(text=='수정'){
			url+="update/"+${emailVO.emsSeq}
		}
		if(text=='삭제'){
			url+="delete/"+${emailVO.emsSeq}
		}
		if(text=='리스트보기'){
			url+="list/"
		}
		document.location.href=url
	})
})
</script>
<section>
	<table class="main-list">
		<tr>
			<td>SEQ: </td><td>${emailVO.emsSeq}</td>
		</tr>
		
		<tr>
			<td>보낸이메일: </td><td>${emailVO.fromEmail}</td>
		</tr>
		
		<tr>
			<td>받는 이메일: </td><td>${emailVO.to_email}</td>
		</tr>
		
		<tr>
			<td>보낸분: </td><td>${emailVO.fromName}</td>
		</tr>
		
		<tr>
			<td>받는분: </td><td>${emailVO.to_name}</td>
		</tr>
		
		<tr>
			<td>제목: </td><td>${emailVO.subject}</td>
		</tr>
		
		<tr>
			<td>내용: </td><td>${emailVO.content}</td>
		</tr>
		
		<tr>
			<td>보낸날짜: </td><td>${emailVO.sendDate}</td>
		</tr>
		
		<tr>
			<td>보낸시간: </td><td>${emailVO.sendTime}</td>
		</tr>
		
		<tr>
			<td><button class="viewButton">수정</button></td>
			<td><button class="viewButton">삭제</button></td>
			<td><button class="viewButton">리스트보기</button></td>
		</tr>
	</table>
</section>
