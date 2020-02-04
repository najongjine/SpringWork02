<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />

<section class="card">
<p class="card-header">제목:  ${bbsVO.bbs_subject }</p>
	<p class="card-body">ID:  ${bbsVO.bbs_id }</p>
	
	<p class="card-body">작성자:  ${bbsVO.bbs_writer }</p>
	<p class="card-body">작성일자:  ${bbsVO.bbs_date }</p>
	<p class="card-body">작성시각:  ${bbsVO.bbs_time }</p>
	
	<p class="card-body">내용:  ${bbsVO.bbs_content }</p>
	<p class="card-body">조회수:  ${bbsVO.bbs_count }</p>
	<p class="card-footer">원글ID:  ${bbsVO.bbs_p_id }</p>
</section>
<div class="btn-group">
	<button type="button" class="btn btn-primary">리스트보기</button>
	<button type="button" class="btn btn-success">수정</button>
	<button type="button" class="btn btn-warning">삭제</button>
	<button type="button" class="btn btn-dark">댓글</button>
</div>
<form:form action="${rootPath }/bbs/reply" modelAttribute="bbsVO">
	<form:textarea path="bbs_content" placeholder="답글을 입력하세요" rows="10"/>
	<button class="btn btn-info">답글저장</button>
</form:form>