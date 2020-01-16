<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<%@ include file="/WEB-INF/views/include/include-head.jspf" %>
<script type="text/javascript">
$(function() {
	$("#btn-write").click( function() {
		if($("#rb_bcode").val()==""){
			alert("도서코드는 반드시 입력해야 합니다")
			$("#rb_bcode").focus()
			return false
		}
		
		if(parseInt($("#rb_rtime").val())< 1){
			alert("독서시간은 반드시 입력해야 합니다")
			$("#rb_rtime").focus()
			return false
		}
		
		if($("#rb_subject").val()==""){
			alert("한줄평은 반드시 입력해야 합니다")
			$("#rb_subject").focus()
			return false
		}
		// 버튼을 클릭하면 submit을 실행하기
		$("form").submit()
	})//유효성 검사 js $("#btn-write").click( function()
	
	/*
	input box에 내용이 있을때 focus()가 위치하면
	내용을 전체 블록설정하여 다른 글자를 입력하면 내용이 삭제되는 기능 구현
	*/
	$("#rb_bname").focus(function() {
		$(this).select()
	})
	$("#rb_bname").keypress( function(event) {
		//enter key눌렀을때
		if(event.keyCode==13){
			let strText=$(this).val()
			if(strText==""){
				alert("도서이름을 입력한 후 enter 누르세요")
				return false
			}
			$("#modal-box").css('display','block')
			$.post("${rootPath}/book/search",
					{strText:strText},
					function(result){
				$("#modal-content").html(result)
			})
		}
	})
	$(".modal-header span").click(function() {
		$("#modal-box").css('display','none')
	})
	
	var toolbar=[
		['style',['bold','italic','underline']],
		['fontsize',['fontsize']],
		['font Style',['fontname']],
		['color',['color']],
		['para',['ul','ol','paragraph']],
		['height',['height']],
		['table',['table']],
		['insert',['link','hr','picture']],
		['view',['fullscreen','codeview']]
	]
	
	$("#rb_text").summernote({
		lang:'ko-KR',
		placeholder:'본문을 입력하세요',
		width:'100%',
		height:'200px',
		toolbar:toolbar,
		disableDragAndDrop:true
	})
	
	$("#rb_star").change(function() {
		let star=$(this).val()
		star=star*10
		$("span.star-red").css("width",star+"%")
		$("span#star-v").text($(this).val())
	})
})
</script>

<style type="text/css">
.input-box{
display: flex;
width: 80%;
margin: 5px auto;
}
.input-box input{
border: none;
border-bottom: 1px solid rgb(52,152,219);
display: block;
width: 100%;
padding: 8px;
}
#rb_bcode{
width: 50%;
margin-right: 5px;
}
#rb_star{
width: 60%;
}
	span.star-box{
		width: 100px;
		margin-left: 20px;
	}
	span.star-box, span.star-red{
		display: inline-block;
		height: 20px;
		overflow: hidden;
		background: url("${rootPath}/img/star.png") no-repeat;
		/*
		배경 이미지를 width:자동, height:40px;
		*/
		background-size: 100px 40px;
	}
	
	span.star-red{
	/*
	배경 이미지를 채울때 왼쪽 아래 꼭지점을 기준으로 배치하라
	*/
		background-position: left bottom;
		line-height: 0;
		vertical-align: top;
		width: 50%;
	} 
</style>

</head>
<body>
<header>
	<h2>My Read Book</h2>
</header>
<%@ include file="/WEB-INF/views/include/include-nav.jspf" %>

<%
/*
글쓰기를 시작할때 controller get로 path를 받았을때 현재 view를 보여주고
input box에 데이터를 입력한후 submit 버튼을 클릭하면 
controller post로 데이터가 전송된다.

path는 
view를 열때 사용했던 path가 그대로 적용된다.

그렇게 사용하지 않을 경우에는 별도로 action을 지정해야 한다.

/rbooks/book/insert path를 실행하면 controller의 GET method가 이를 수신하여
현재 input.jsp를 보여주고 데이터입력한 후 저장 button을 클릭하면
/rbooks/book/insert path의 post method로 데이터가 전송된다.

특별히 action을 지정하지 않으면 위와같은 매커니즘으로 사용된다.
기본값으로 사용하지 않을경우 action을 지정하여 사용할수 있다.

spring form tag를 사용할경우는 기본 method가 post이고 html form tag는 기본method가 get.

button은 type을 지정하지 않으면 type="submit" 이 기본값.
버튼을 클릭하면 form에 입력한 데이터를 서버로 전송하는 기능을 한다.

button 에 특별히 이벤트를 적용하고 싶으면 type="button"으로 지정할수 있다.

button에는 3가지 type이 있다.
submit: 기본값. form안에 있는 경우 form에 담긴 데이터를 서버로 전송하는 기능.
	input box가 1개만 있을경우 enter키에 반응하여 버튼을 클릭한 것처럼 동작을 한다.
button:모든 기능을 제거하고 별도의 event를 설정해야 한다.
reset: form안에 있는 경우 form의 input box에 임의로 작성한 데이터를 모두 초기화 하는 기능.

중첩된 form 의 action ... 나중에 생각.
*/
%>
<section id="main-writer">
	<article>
		<form:form action="" modelAttribute="rBookVO">
			<div class="input-box">
			<form:input type="text" path="rb_bcode" placeholder="도서코드"/>
			<input id="rb_bname" name="rb_bname" placeholder="도서이름을 입력한후 enter...">
			</div>
			
			<div class="input-box">
			<form:input type="date" path="rb_date" placeholder="독서일자"/>
			</div>
			
			<div class="input-box">
			<form:input type="time" path="rb_stime" placeholder="독서시작시간"/>
			</div>
			
			<div class="input-box">
			<form:input type="text" path="rb_rtime" placeholder="독서시간"/>
			</div>
			
			<div class="input-box">
			<form:input type="text" path="rb_subject" placeholder="한줄평"/>
			</div>
			
			<div class="input-box">
			<form:input type="range" path="rb_star" placeholder="별점" min="1" max="10"/>
			<span class="star-box">
				<span class="star-red"></span>
			</span>
			<span id="star-v"></span>
			</div>
			
			<div class="input-box">
			<form:textarea path="rb_text" placeholder="독서소감"></form:textarea>
			</div>
			
			<div id="main-button">
				<button id="btn-write" type="button" class="biz-orange flex-right">독서록 저장</button>
				<button id="btn-clear" type="reset" class="biz-red">새로작성</button>
				<button id="btn-list" type="button" class="biz-blue">리스트로 가기</button>
			</div>
		</form:form>
	</article>
	
</section>

<div id="modal-box">
	<div class="modal-header">
		<span>&times;</span>
	</div>
	<div id="modal-content">
		
	</div>
</div>
</body>
</html>