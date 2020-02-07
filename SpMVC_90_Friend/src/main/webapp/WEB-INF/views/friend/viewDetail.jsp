<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>view detail</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
$(function() {
	let f_id="${friendVO.f_id }"
	$("#update").click(function() {
		$("#update").hide()
		$.post("${rootPath}/friend/updateForm",
			{f_id:f_id},
			function(result){
				$("#inputForm").html("")
				$("#inputForm").html(result)
		})//end post
	})//end update
	$("#delete").click(function() {
		let cfrm=confirm("진짜 삭제하시겠습니까?");
		if(cfrm==true){
			$.post("${rootPath}/friend/delete",
				{f_id:f_id},
				function(result) {
					if(result=='success'){
						alert("삭제성공!!")
						document.location.replace("${rootPath}/friend/showAll")
						return false
					}//end if
					else{
						alert("삭제 실패")
						return false
					}	
			})//end post
		}//end if
		
	})//end delete
})
</script>
</head>
<%@ include file="/WEB-INF/views/friend/include-nav.jsp" %>
<body>
<section>
	<p><label>ID: </label> ${friendVO.f_id }</p>
	<p><label>이름: </label> ${friendVO.f_name }</p>
	<p><label>전화번호: </label> ${friendVO.f_phone }</p>
	<p><label>주소: </label> ${friendVO.f_address }</p>
	<p><label>관계: </label> ${friendVO.f_relation }</p>
</section>
<section id="inputForm"></section>
<section>
	<button id="update" type="button">수정</button>
	<button id="delete" type="button"">삭제</button>
</section>
</body>
</html>