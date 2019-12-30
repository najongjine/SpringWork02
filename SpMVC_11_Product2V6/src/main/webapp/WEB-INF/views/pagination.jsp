<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath }"/>
<article>
	<ul class="pagination">
		<c:if test="${pageDTO.startPageNo>1 }">
<<<<<<< HEAD
		<li class="page-item"><a href="${rootPath }/plist?currentPageNo=1" class="page-link">1</a></li>
		<li class="page-item"><a href="${rootPath }/plist?currentPageNo=${pageDTO.prePageNo}" class="page-link">&lt;</a></li>
=======
		<li class="page-item"><a href="${rootPath }/${url}?search=${search}&currentPageNo=1" class="page-link">1</a></li>
		<li class="page-item"><a href="${rootPath }/${url}?search=${search}&currentPageNo=${pageDTO.prePageNo}" class="page-link">&lt;</a></li>
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
		</c:if>
		<c:if test="${pageDTO.startPageNo>2 }">
		<li class="page-item"><a class="page-link">&middot;&middot;&middot;</a></li>
		</c:if>
		
		<c:forEach begin="${pageDTO.startPageNo }" end="${pageDTO.endPageNo }" var="pageNo">
		<li class="page-item <c:if test="${pageNo==pageDTO.currentPageNo }"> active </c:if>" >
<<<<<<< HEAD
		<a href="${rootPath }/plist?currentPageNo=${pageNo}" class="page-link">${pageNo }
=======
		<a href="${rootPath }/${url}?search=${search}&currentPageNo=${pageNo}" class="page-link">${pageNo }
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
		</a></li>
		</c:forEach>
		
		<c:if test="${pageDTO.endPageNo!=pageDTO.finalPageNo }">
		<li class="page-item"><a class="page-link">&middot;&middot;&middot;</a></li>
<<<<<<< HEAD
		<li class="page-item"><a href="${rootPath }/plist?currentPageNo=${pageDTO.nextPageNo }" class="page-link">&gt;</a></li>
		<li class="page-item"><a href="${rootPath }/plist?currentPageNo=${pageDTO.finalPageNo}" class="page-link">${pageDTO.finalPageNo}</a></li>
=======
		<li class="page-item"><a href="${rootPath }/${url}?search=${search}&currentPageNo=${pageDTO.nextPageNo }" class="page-link">&gt;</a></li>
		<li class="page-item"><a href="${rootPath }/${url}?search=${search}&currentPageNo=${pageDTO.finalPageNo}" class="page-link">${pageDTO.finalPageNo}</a></li>
>>>>>>> 9d05e48e65bbf5f0c3c46ae78ac8c95f660b9168
		</c:if>
	</ul>
</article>