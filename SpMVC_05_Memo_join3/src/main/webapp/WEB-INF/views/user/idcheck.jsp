<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	$("#id_use").click(function() {
		/*
		회원가입 창의 u_id input box에 현재창의 u_id 값을 보내기
		*/
		$("#u_id",opener.document).val($("#u_id").val())
		window.close()
		//window.open('about:blank','_self').self.close()
	})
})
</script>
</head>
<body>
<c:choose>
<c:when test="${ID_YES }">
<h3>이미 가입된 ID 입니다.</h3>
</c:when>
<c:when test="${ID_YES==false && empty u_id }"><h3>아이디를 입력해 주세요</h3></c:when>
<c:otherwise>
<h3>사용할수 있는 ID 입니다</h3>
</c:otherwise>
</c:choose>
<form>
<input name="u_id" id="u_id" value="${u_id }">
<button>다시검색</button>
<button type="button" id="id_use">id 사용</button>
</form>

</body>
</html>