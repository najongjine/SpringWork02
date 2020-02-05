<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<script>
$(function() {
	$("button.btn-c-save").click(function() {
		let cmt_writer=$("#cmt_writer").val()
		let cmt_text=$("#cmt_text").val()
		
		if(cmt_writer==""){
			alert("댓글 작성자를 입력하세요")
			$("cmt_writer").focus()
			return false
		}
		if(cmt_text==""){
			alert("댓글 입력하세요")
			$("cmt_text").focus()
			return false
		}
		
		// json 형태로 데이터 생성
		let cmt_data={cmt_p_id:'${bbsVO.bbs_id}',
				cmt_writer:cmt_writer,
				cmt_text:cmt_text}
		$.ajax({
			url:'${rootPath}/bbs/cmt_write',
			method:'POST',
			data:cmt_data,
			success:function(result){
				$("#cmt_list").html("")
				$("#cmt_list").html(result)
				return false
			},
			error:function(){
				alert("서버와 통신오류")
			}
		})
	})
	$.post("${rootPath}/bbs/cmt_list",{cmt_p_id:"${bbsVO.bbs_id}"},function(result){
		$("#cmt_list").html(result)
	})
})
</script>
<section class="card">
	<p class="card-header">제목: ${bbsVO.bbs_subject }</p>
	<p class="card-body">ID: ${bbsVO.bbs_id }</p>

	<p class="card-body">작성자: ${bbsVO.bbs_writer }</p>
	<p class="card-body">작성일자: ${bbsVO.bbs_date }</p>
	<p class="card-body">작성시각: ${bbsVO.bbs_time }</p>

	<p class="card-body">내용: ${bbsVO.bbs_content }</p>
	<p class="card-body">조회수: ${bbsVO.bbs_count }</p>
	<p class="card-footer">원글ID: ${bbsVO.bbs_p_id }</p>
	<div class="card-body bg-info">
		<div id="cmt_list" class="form-group bg-white">
			댓글 리스트 보기
		</div>
		<div class="form-group">
			<input id="cmt_writer" name="cmt_writer" class="form-control"
				placeholder="작성자">
		</div>
		<div class="form-group">
			<textarea id="cmt_text" name="cmt_text" class="form-control"></textarea>
			<button class="btn btn-dark btn-c-save">저장</button>
		</div>
	</div>
</section>

<div class="btn-group">
	<button type="button" class="btn btn-primary">리스트보기</button>
	<button type="button" class="btn btn-success">수정</button>
	<button type="button" class="btn btn-warning">삭제</button>
</div>

<c:if test="${bbsVO.bbs_p_id < 1}">
	<script>
		$(function() {
			$("button.btn-r-save").click(function() {
				let bbs_writer = $("#bbs_writer").val()
				let bbs_content = $("#bbs_content").val()

				if (bbs_writer == "") {
					alert("작성자를 입력하세요")
					$("#bbs_writer").focus()
					return false
				}
				if (bbs_content == "") {
					alert("답글 본문을 입력하세요")
					$("#bbs_content").focus()
					return false
				}

				$("form").submit()
			})

		})
	</script>
	<form:form action="${rootPath }/bbs/reply" modelAttribute="bbsVO">
		<div class="form-group">
			<input id="bbs_writer" class="form-control" name="bbs_writer"
				placeholder="댓글 작성자">
		</div>
		<textarea id="bbs_content" name="bbs_content" placeholder="답글을 입력하세요"></textarea>
		<button class="btn btn-info btn-r-save">답글저장</button>
	</form:form>
</c:if>