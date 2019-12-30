<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />

<!-- spring의 formtag lib
html의 input,form 등의 입력 box용 tag를 확장하여 spring controller와 연동이 쉽게 해주는 lib -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ user insert Page □□□</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		function idcheck() {
			let top = 500
			/*(window.screen.availTop+(window.screen.availHeight/2))
			- (window.screen.height/2)*/
			let left = 500
			/*(window.screen.availLeft + (window.screen.availWidth/2))
			-(window.screen.width/2)*/
			let u_id = $("#u_id").val()
			let status = "toolbar=no,"
			status += "scrollbars=yes,"
			status += "resizable=no,"
			status += "top=500,"
			status += "left=500,"
			status += "width=700,"
			status += "height=400,"
			if (u_id == "") {
				alert("ID를 입력한 후 Enter")
				return false
			}
			openWin = window.open("${rootPath}/user/idcheck?u_id=" + u_id,
					"_blank", status)
			//openWin.moveTo(left,top)
		}
		
		$("#u_id").keypress(function(e) {
			if (e.keyCode == 13) {
				idcheck()
			}
		})
		
		//event handler에 함수목록을 등록하는 절차. 이때는 함수를 객체처럼 등록함.
		// call back 함수등록
		$("#id_check").click(idcheck)
		$("#btn-save").click(function() {
			let pass = $("#u_password").val()
			if (pass == "") {
				alert("비밀번호를 입력하세요")
				$("#u_password").focus()
				return false
			}
			let re_pass = $("#re_password").val()
			if (re_pass == "") {
				alert("비밀번호를 한번더 입력하세요")
				$("#re_password").focus()
				return false;
			}
			if (pass != re_pass) {
				alert("비밀번호가 일치하지 않습니다!!")
				$("#u_password").val("")
				$("#re_password").val("")
				$("#u_password").focus()
				return false
			}
			let u_name = $("#u_name").val()
			if (u_name == "") {
				alert("이름은 반드시 입력해야 합니다")
				$("#u_name").focus()
				return false;
			}

			$("form").submit()

		})

	})
</script>
<style type="text/css">
fieldset {
	width: 70%;
	margin: 20px auto;
	border: 1px solid green;
	border-radius: 10px;
}

legend {
	font-weight: bold;
	font-size: 20px;
}

input, textarea {
	display: inline-block;
	width: 90%;
	padding: 8px;
	margin: 5px;
	border-radius: 20px;
}

input:focus, textarea:focus, button {
	border: 2px solid blue;
	outline: none;
}

input:hover {
	background-color: #ddd;
	border: 2px solid red;
}

.in-error {
	display: inline-block;
	margin-left: 20px;
	font-size: 12px;
	color: red;
}

span#u_id_msg {
	display: none;
}

#u_id {width 70%;
	
}
</style>
</head>
<body>
	<fieldset>
		<legend>
			<c:if test="${TITLE==null }">회원가입</c:if>
		</legend>
		<legend>
			<c:if test="${TITLE!=null }">${TITLE }</c:if>
		</legend>
		<form:form modelAttribute="userDTO" class="user-form"
			autocomplete="on">

			<%
				/*html tag의 inputbox와 달리 name이라는 속성을 사용하지 않고 path라는 속성이 변수설정역활을 수행
										*/
			%>
			<div class="in-box-border">
				<form:input path="u_id" type="text" class="in-box"
					placeholder="사용자 아이디를 입력하세요" />
				<button type="button" id="id_check">아이디검사</button>
				<br />
				<form:errors path="u_id" class="in-error" />
				<br /> <span id="u_id_msg"></span>
			</div>

			<div class="in-box-border">
				<form:input path="u_password" type="password" class="in-box"
					placeholder="비밀번호를 입력하세요" />
				<br />
				<form:errors path="u_password" class="in-error" />
			</div>

			<%
				/*
											비밀번호 확인 inputbox를 표준 html로 작성
											비밀번호 확인은 서버로 데이터를 전송할 필요가 없기 때문에.
											또한 form:input으ㅜ로 작성을 하게되면 DTO에 해당 필드변수를 작성해야하는 불편이 있기 때문에.
											이 항목에 이력된 값은 서버로 전송하기전
											비밀번호가 같은지만 검사하면 되기 때문에.*/
			%>
			<div class="in-box-border">
				<form:input type="password" path="re_password"
					placeholder="비밀번호를 다시한번 입력하세요" />
				<form:errors path="re_password" class="in-error" />
			</div>

			<div class="in-box-border">
				<form:input path="u_name" class="in-box" placeholder="이름을 입력하세요" />

				<br />
				<form:errors path="u_name" class="in-error" />
			</div>

			<div class="in-box-border">
				<form:input path="u_nick" class="in-box" placeholder="닉네임을 입력하세요" />
				<br />
				<form:errors path="u_nick" class="in-error" />
			</div>

			<div class="in-box-border">
				<form:input path="u_tel" type="number" class="in-box"
					placeholder="전화번호를 숫자로만 입력하세요" />
				<br />
				<form:errors path="u_tel" class="in-error" />
			</div>

			<button type="button" id="btn-save">save</button>
		</form:form>
	</fieldset>
</body>
</html>