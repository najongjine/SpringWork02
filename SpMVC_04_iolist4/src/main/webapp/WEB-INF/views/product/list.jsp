<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style type="text/css">
p#insert {
	margin-left: 40px;
}
</style>
<script>
	$(function() {
		$(".content-body").click(function(e) {
			let p_code = $(this).attr("id")
			/*
			주소창에 /lolist/view를 입력하여 서버에 전송하라
			id변수에 값을실어서 보내라
			 */
			document.location.href = "${rootPath}/iolist/view?id=" + p_code
		})
	})
</script>
</head>
<body>

	<%@ include file="/WEB-INF/views/include/include-product-header.jspf"%>
	<section>
		<article>
			<p id="insert">
				<a href="${rootPath }/product/insert"><button>새로등록</button></a>
		</article>
		<%@ include file="/WEB-INF/views/product/list-body.jsp" %>
	</section>
</body>
</html>