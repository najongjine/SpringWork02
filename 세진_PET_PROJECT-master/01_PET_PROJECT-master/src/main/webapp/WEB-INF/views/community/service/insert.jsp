<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>우리 애를 부탁해</title>
<link rel="stylesheet" href="${rootPath}/css/home.css?ver=20191228001" type="text/css">
<link rel="stylesheet" href="${rootPath}/css/community.css?ver=20191222003"  type="text/css" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){

	$("#lee-btn-insert").click(function(){
		
		if ($("#lee-input-auth").val() == ""){
			alert("작성자 ID는 반드시 입력해야합니다.")
			$("#lee-input-auth").focus();
			return false
		}
		
		if ($("#lee-input-subject").val() == ""){
			alert("제목는 반드시 입력해야합니다.")
			$("#lee-input-subject").focus();
			return false
		}
		
		if ($("#lee-textarea").val() == ""){
			alert("내용는 반드시 입력해야합니다.")
			$("#lee-textarea").focus();
		}
		
		$("form").submit()

	})
		
})
</script>
</head>
<body>
<%@ include file="/WEB-INF/views/include/include-header.jspf"%>
<%@ include file="/WEB-INF/views/include/include-nav.jspf"%>

<div id="lee-community-insert">
	<h5>고객센터 글쓰기</h5>
	<fieldset>
		<legend id="lee-legend">고객센터 작성</legend>
		<form:form modelAttribute="seDTO" autocomplete="on" class="lee-memo-form">
			<input name="se_seq" type="hidden" value='<c:out value="${seDTO.se_seq}" default="1"/>'>
			<form:input path="se_auth" class="in-box" placeholder="작성자 ID" id="lee-input-auth"/><br />
			<form:input path="se_date" class="in-box" placeholder="작성일자" id="lee-input-date"/><br />
			<form:input path="se_subject" class="in-box" placeholder="제목을 입력하세요" id="lee-input-subject"/><br />
			<form:textarea path="se_text" rows="5" placeholder="내용을 입력하세요" id="lee-textarea"/><br />
			<button id="lee-btn-insert">저장</button>
		</form:form>
	</fieldset>
</div>
<%@ include file="/WEB-INF/views/include/include-footer.jspf"%>
</body>
</html>