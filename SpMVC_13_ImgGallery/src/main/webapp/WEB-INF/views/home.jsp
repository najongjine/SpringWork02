<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ Img Gallery □□□</title>

<!-- include libraries(jQuery, bootstrap) -->
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>


<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-lite.js"></script>
<script type="text/javascript" src="${rootPath }/javascript/summernote-ko-KR.js?ver=1"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.contextMenu.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-contextmenu/2.9.0/jquery.ui.position.min.js"></script>

<style type="text/css">
	*{
		box-sizing: border-box;
		margin: 0px;
		padding: 0px;
	}
	body{
		width: 100%;
	}
	header{
		background-color: #41d3bd;
		margin: 0;
		padding: 1rem;
		color: white;
	}
	#img_box{
		border: 1px solid green;
		display: flex;
		flex-wrap: wrap;
	}
	.img_panel{
		padding: 0.01rem 16px;
		margin-top: 16px;
		margin-bottom: 16px;
	}
	.img_card{
		width: 200px;
		height: 200px;
		margin: 10px;
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.16), 0 4px 20px 0 rgba(0,0,0,0.19);
	}
	.bz-button{
		border: none;
		display: inline-block;
		padding: 8px 16px;
		margin:5px;
		vertical-align: middle;
		text-decoration: none;
		color: white;
		background-color: blue;
		text-align: center;
		cursor: pointer;
		white-space: nowrap;
	}
	.bz-button:hover {
		box-shadow: 0 8px 16px rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.2);
	}
	div.input_box{
	width:90%;
		margin: 5px auto;
	}
	input[type="text"]{
		padding: 8px;
		display: block;
		border: 1px solid #ccc;
		border-radius:5px;
		width:100%;
		margin: 8px auto;
	}
	#d_d_box{
		width: 100%;
		height: 300px;
		color: #aaa;
		border:1px solid green;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	#img_view{
		display: none;
		
	}
}
</style>
<script type="text/javascript">
$(function() {
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
	$("#img_text").summernote({
		lang:'ko-KR',
		placeholder:'본문을 입력하세요',
		width:'100%',
		height:'200px',
		toolbar:toolbar
	})
	$("#btn_img_up").click(function() {
		document.location.href="${rootPath}/image/upload"
	})
	$("#d_d_box").on('dragover',function(e){
		$("#d_d_box h3").text("파일을 내려 놓으세요!!!")
		return false
	})
	
	/*
	file 1개를 drag&drop으로 업로드 수행하기
	드래그앤 드롭하면 실제 파일은 이름이 바뀌어서 xml에서 지정한 경로에 파일을 업로드함
	DB에 파일 이름 저장하는 파트는 저장 버튼 눌렀을때만.
	파일 이름은 실제 업로드 된 순간 img_upload.jsp 에 만들어놓은 path에 자동으로 셋팅되게 ajax에서 코드 짜놓음.
	img_upload,jsp에서 저장 버튼 누르면 이미 세팅된 파일 이름이 컨트롤러로 넘어가서 DB에 저장
	*/
	$("#d_d_box").on('drop',function(e){
		$("#d_d_box h3").text("파일 업로드중!")
		
		//drop한 파일리스트 추출
		let files=e.originalEvent.dataTransfer.files
		
		//리스트에서 첫번째 파일만 추출
		let file=files[0]

		//추출된 파일정보를 서버에 먼저 업로드
		
		//js FormData 클래스를 사요ㅕㅇ해서 서버에 파일 업로드 준비
		let formData=new FormData()
		formData.append('file',file)
		
		$.ajax({
			url:'${rootPath}/rest/file_up',
			method:'POST',
			data:formData,
			
			/* 파일업로드 필수옵션 */
			processData:false,
			contentType:false,
			
			success:function(result){
				if(result=='FAIL'){
					alert("파일업로드 오류")
				} else{
					/*
					img_file 이란 id는 form:form 태그의 img_upload.jsp의 path와 이름이 같음
					$("#img_file").val(result) 이 문장이 path 부분의 img_file에 값을 채워넣어줌
					img_upload.jsp 에서 저장 버튼을 누르면 세팅된 값을 post로 넘겨서
					controller에서 파일 이름만 DB에 저장
					*/
					$("#img_file").val(result)
					$("#img_view").css("display","block")
					$("#img_view").attr("src",'${rootPath}/images/'+result)
					$("#d_d_box h3").css("display","none")
				}
			},
			error:function(){
				alert("서버통신 오류")
			}
		})
		return false
	})
	$.contextMenu({
		selector:'.img_card',
		items:{
			'edit':{name:"수정",icon:'edit'},
			'delete':{name:"삭제",icon:'delete'}
		}
	})
})
</script>
</head>
<body>
<header>
	<a href="${rootPath}/image/list"><h3>Img Gallery</h3></a>
</header>
<section>
	<c:if test="${BODY=='UPLOAD' }">
		<%@ include file="/WEB-INF/views/body/img_upload.jsp" %>
	</c:if>
</section>
<section id="img_box">
	<c:forEach items="${imgList}" var="img">
		<%@ include file="/WEB-INF/views/include/img_card.jsp" %>
	</c:forEach>
</section>

<section>
	<button id="btn_img_up" class="bz-button">이미지 올리기</button>
</section>
</body>
</html>