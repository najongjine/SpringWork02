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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

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
	section{
		width: 90%;
		margin: 10px auto;
	}
	#img_box{
		margin:10px auto;
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
		/*이미지가 cardbox보다 클때 이미지 자르기*/
		overflow:hidden;
		box-shadow: 0 4px 10px 0 rgba(0,0,0,0.16), 0 4px 20px 0 rgba(0,0,0,0.19);
		display: flex;
		justify-content: center;
		flex-flow: column;
	}
	.img_card .img_title{
	padding: 0.5;
	text-align: center;
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
	a{
	text-decoration: none;
	color: inherit;
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
	.img_list{
	display: flex;
	flex-wrap: wrap;
	}
	.img_view img{
	width: 200px;
	margin: 5px;
	}
}
</style>
<script type="text/javascript"> var rootPath="${rootPath}"</script>
<script type="text/javascript" src="${rootPath }/javascript/image_upload.js"></script>
<script type="text/javascript" src="${rootPath }/javascript/images_upload.js"></script>
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
		toolbar:toolbar,
		disableDragAndDrop:true
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
		let fileLen=files.length
		//if(fileLen>1){
			let formData=new FormData()
			for(let i=0;i<files.length;i++){
				//drop한 파일들을 모두 추가
				formData.append('files',files[i])
			}
			
			files_up(formData)
			return false
		/*
		} else {
		//리스트에서 첫번째 파일만 추출
		let file=files[0]

		//추출된 파일정보를 서버에 먼저 업로드
		
		//js FormData 클래스를 사요ㅕㅇ해서 서버에 파일 업로드 준비
		let formData=new FormData()
		formData.append('file',file)
		file_up(formData)
		}
		return false
		*/
	})
	
	var contextCallBack=function(key,options){
		if(key=='edit'){
			let img_seq=$(this).attr("data-seq")
			document.location.href="${rootPath}/image/update/"+img_seq
		}
		if(key=='delete'){
			if(confirm("이미지를 삭제할까요?")){
				let img_seq=$(this).attr("data-seq")
				
				$.ajax({
					url:"${rootPath}/image/delete",
					data:{img_seq:img_seq},
					type:'POST',
					success:function(result){
						if(result<1)
							alert("삭제도중 문제발생")
					},
					error:function(){
						alert("서버 통신오류")
					}
				})
				document.location.replace("${rootPath}/")
				
				//이벤트 버블링 금지
				return false
			}
		}
	}
	
	/*
	jquery 응용
	마우스제어 (오른쪽마우스 클릭:=context menu) 만들어 주는 툴
	*/
	$.contextMenu({
		/*
		어떤 태그에서 작동하게 할것인가
		*/
		selector:'.img_card',
		items:{
			/*
			요런 메뉴를 만들겠다
			*/
			'edit':{name:"수정",icon:'edit'},
			'delete':{name:"삭제",icon:'delete'}
		},
		callback: contextCallBack
	})
	
	var img_context=function(key,option){
		let id=$(this).attr("data-id")
		if(key=="delete"){
			if(confirm(id+" 이미지를 삭제할까요?")){
				$.post("${rootPath}/rest/image_delete",
						{img_id:id},
						function(result) {
							if(result=="OK"){
								document.location.replace(document.location.href)
							}
							else{
								alert("파일을 삭제할수 없음")
								document.location.replace(document.location.href)
							}
						})
				/* 내가한거
				$.ajax({
					url:"${rootPath}/image/deleteSubImg",
					data:{img_file_seq:id},
					type:'POST',
					success:function(result){
						if(result<1)
							alert("삭제도중 문제발생")
					},
					error:function(){
						alert("서버 통신오류")
					}
				})
				document.location.replace("${rootPath}/")
				
				//이벤트 버블링 금지
				return false*/
			} 
		}//end if
		else if(key=="copy"){
			
		}
		else if(key=="loading"){
			let file=$(this).find("img").attr("src")
			window.open(file,"target=_new")
		}
		
	}//end img_context
	$.contextMenu({
		/*
		어떤 태그에서 작동하게 할것인가
		*/
		selector:'.img_view',
		items:{
			/*
			요런 메뉴를 만들겠다
			*/
			'loading':{name:"확대보기",icon:'loading'},
			'copy':{name:"다운로드",icon:'copy'},
			'search':{name:"검색",icon:'fas fa-search'},
			'delete':{name:"삭제",icon:'delete'}
		},
		callback: img_context
	})
	
})
</script>
</head>
<body>
<header>
	<a href="${rootPath}/image/list"><h3>Img Gallery</h3></a>
</header>

<c:choose>
	<c:when test="${BODY=='UPLOAD' }">
	<section>
		<%@ include file="/WEB-INF/views/body/img_upload.jsp" %>
	</section>
	</c:when>
	<c:otherwise>
	<section id="img_box">
		<c:forEach items="${imgList}" var="img">
			<%@ include file="/WEB-INF/views/include/img_card.jsp" %>
		</c:forEach>
	</section>
	</c:otherwise>
</c:choose>

<section id="img_box">
	
</section>

<section>
	<button id="btn_img_up" class="bz-button">이미지 올리기</button>
</section>
</body>
</html>