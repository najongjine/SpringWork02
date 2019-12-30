<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<c:set var="rootPath" value="${pageContext.request.contextPath}" /> 

<article id="lee-pagination-box">
	<ul class="lee-pagination">

		<c:if test="${pageDTO.startPageNo > 1}">	
			<li class="lee-page-item"><a href="${rootPath}/community/list?currentPageNo=1" class="lee-page-link">1</a></li>
			<li class="lee-page-item"><a href="${rootPath}/community/list?currentPageNo=${pageDTO.prePageNo}" class="lee-page-link">&lt;</a></li>
		</c:if>
		
		<c:if test="${pageDTO.startPageNo > 2}">
			<li class="lee-page-item"><a class="lee-page-link">&middot;&middot;&middot;</a></li>
		</c:if>
	
		<c:forEach begin="${pageDTO.startPageNo}" end="${pageDTO.endPageNo}" var="pageNo">
			<li class="lee-page-item <c:if test="${pageNo == pageDTO.currentPageNo}">active</c:if>"> 
			<a href="${rootPath}/community/list?currentPageNo=${pageNo}" class="lee-page-link">${pageNo}
			</a>
		</li>
		</c:forEach>
	
		<c:if test="${pageDTO.endPageNo != pageDTO.finalPageNo}">
			<li class="lee-page-item"><a class="lee-page-link">&middot;&middot;&middot;</a></li>
			<li class="lee-page-item"><a href="${rootPath}/community/list?currentPageNo=${pageDTO.nextPageNo}" class="lee-page-link">&gt;</a></li>
			<li class="lee-page-item">
			<a href="${rootPath}/community/list?currentPageNo=${pageDTO.finalPageNo}" class="lee-page-link">${pageDTO.finalPageNo}</a></li>
		</c:if>
	</ul>

</article>
