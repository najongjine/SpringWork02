<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="${rootPath }/js/jquery-3.4.1.js"></script>
<script>
/*jquery*/
$(function() {
	/*
	if(class.content-body==click){
		.....
	}
	click(function(){}) 익명함수(무명함수)
	click event가 발생했을때 call되어 실행될 코드들의 묶음*/
	$(".content-body").click(function() {
		//$(this) 현재 클릭된 요소|tag 의 모든 정보
		let id=$(this).attr("data-id")
		let auth=$(this).attr("data-auth")
		document.location.href="${rootPath}/memo/view?id="+id
	})
	$("#th-date").click(function() {
	})
})
</script>
</head>
<body>
<%
/*
css, js 파일을 만들고 jsp, html 에서 import,를 하여 사용할 경우
해당파일을 변경(수정) 했을경우 tomcat이 해당 파일이 변경 됬다는것을 알지 못하는 현상이 자주 발생.
이럴경우 브라우저의 방문기록을 삭제하면 변경된 내용이 반영이 되는데,
상당히 불편하고 배포된 상태에서 불특정 다수가 웹을통해 접속했을경우
사용자에게 일일이 브라우저 방문기록을 삭ㅈ베해달라 요청할수도 없다.
대안으로 파일이름을 변경하여 서버를 reload 하는 방법도 계속해서 파일이름을 변경해야하는 상황이 좋지않다.
현재 많은 app에서 사용하는 방법으로 파일이름 뒤에 dummy query를 부착하여
마치 파일이름을 변경하는 것처럼 tomcat에게 알리는 방법.
*/
%>
<link rel="StyleSheet" type="text/css" href="${rootPath }/css/list-table.css?ver=1">
	<table>
		<tr >
			<th>SQ</th>
			<th id="th-date">작성일</th>
			<th>작성시각</th>
			<th>작성자</th>
			<th>카테고리</th>
			<th>제목</th>
		</tr>
		<c:choose>
			<c:when test="${empty MEMO_LIST}">
				<tr>
					<td colspan="6">no memo list</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${MEMO_LIST}" var="memo" varStatus="index">
					<tr class="content-body" data-id="${memo.m_seq }"
					data-auth="${memo.m_auth }"><!-- 사용자 정의 변수 -->
						<td>${index.count}</td>
						<td>${memo.m_date }</td>
						<td>${memo.m_time }</td>
						<td>${memo.m_auth }</td>
						<td>${memo.m_cat }</td>
						<td>${memo.m_subject }</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
</body>
</html>