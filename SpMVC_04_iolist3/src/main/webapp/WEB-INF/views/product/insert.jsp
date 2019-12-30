<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<%@ include file="/WEB-INF/views/include/include-css.jspf"%>
<style>
.inbox {
	display: inline-block;
	width: 70%;
}

.in-box>input {
	padding: 8px;
	margin: 3px;
	display: inline-block;
	width: 70%;
	border: 1px solid #ccc;
}

.in-box>input:hover {
	background-color: #ddd;
	border: 1px solid blue;
}

.in-label {
	display: inline-block;
	width: 20%;
	text-align: left;
	margin-right: 5px;
	padding: 8px;
}
fieldset{
width:70%;
margin: 20px auto;
border-radius:5px; 
}
legend{
font-size: 12pt;
font-weight: bold;
color: #3d65ff;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include-product-header.jspf"%>
	<form action="" method="POST">
	<fieldset>
	<legend>거래처 정보 입력</legend>
		<!-- label의 for 속성: input box와 한 그룹으로 설정
label을 클릭했을때 마치 input box를 클릭한거처럼 input box에 focus를 지정 -->
		<label for="p_code" class="in-label">상품코드</label>
		<div class="in-box">
		<!-- 주소창에 있는 ? 다음에 오는 query는 원리가 parameter임. 즉 변수임.
		html 태그안에 name= 다음에 오는것은 변수임. query parameter 와 html name 이름이 같으면
		같은 변수로 취급해버림. 하지만 query parameter 값을 덮어씌우면 spring이 깨질수가 있어서 걍 
		값을 덮어쓰기 하려하면 list로 받아버림 -->
			<input name="p_code" id="p_code" value="${PRODTO.p_code }" readonly="readonly">
		</div>
		<label for="p_name" class="in-label">상품명</label>
		<div class="in-box">
			<input name="p_name" id="p_name" value="${PRODTO.p_name }" >
		</div>
		<label for="p_iprice" class="in-label">도매가격</label>
		<div class="in-box">
			<input name="p_iprice" id="p_iprice" value="${PRODTO.p_iprice }">
		</div>
		<label for="p_oprice" class="in-label">판매가격</label>
		<div class="in-box">
			<input name="p_oprice" id="p_oprice" value="${PRODTO.p_oprice }">
		</div>
		<label for="p_vat" class="in-label">부가세여부</label>
		<div class="in-box">
			<input name="p_vat" id="p_vat" value="${PRODTO.p_vat }">
		</div>
		<label class="in-label"></label>
		<div class="in-box">
			<button id="btn-save">저장</button>
		</div>
		</fieldset>
	</form>
</body>
</html>