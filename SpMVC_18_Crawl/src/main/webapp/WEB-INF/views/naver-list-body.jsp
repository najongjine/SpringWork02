<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>

<!--
col-xl: >=992px
	col-lg-2: 만약 width 992px 보다 크면 2/12 만큼의 크기를 1개의 box로 설정
col-md: >= 768px
	col-md-4: width 992px 미만이고 768px 이상이면 4/12 만큼의 크기를 1개의 box로 설정
col-sm : >= 576px 
	col-sm-12: width 768px 미만이고 576px 이상이면 12/12 전체 가로 방향으로 1칸짜리 box를 설정하라.
 -->
<div class="col-lg-2 col-md-4 col-sm-12">
	<div class="card">
		<div class="card-header">${NAVER.m_title }</div>
		<div class="card-body">
			<img src="${NAVER.m_image_url}" >
		</div>
		
		<div class="card-footer">
			<a href="${NAVER.m_detail_url }">자세히 보기</a>
		</div>
	</div>
</div>