<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<c:choose>
<c:when test="${mode=='update' }">
<form:form action="${rootPath }/friend/updateDB" modelAttribute="friendVO">
	<form:input path="f_id" hidden="true"/>
	<label>이름: </label><form:input path="f_name"/>
	<label>전화번호: </label><form:input path="f_phone" type="phone"/>
	<label>주소: </label><form:input path="f_address" type="address"/>
	<label>관계: </label><form:input path="f_relation"/>
	<p><button>수정</button><p>
</form:form>
</c:when>
<c:otherwise>
<%@ include file="/WEB-INF/views/friend/include-nav.jsp" %>
<form:form modelAttribute="friendVO">
	<form:input path="f_id" hidden="true"/>
	<label>이름: </label><form:input path="f_name"/>
	<label>전화번호: </label><form:input path="f_phone" type="phone"/>
	<label>주소: </label><form:input path="f_address" type="address"/>
	<label>관계: </label><form:input path="f_relation"/>
	<p><button>추가</button><p>
</form:form>
</c:otherwise>
</c:choose>
