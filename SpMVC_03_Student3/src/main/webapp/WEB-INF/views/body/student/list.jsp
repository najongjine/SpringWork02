<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath }" />
<style>
table {
	border-collapse: collapse;
	border-spacing: 0;
	width: 90%;
	border: 1px solid blue;
	margin: 20px auto;
}

table tr {
	/*border: 1px dashed red;*/
	
}

table td, table th {
	padding: 8px;
	vertical-align: top;
}

table th {
	text-align: left;
}

table tr:nth-child(odd) {
	background-color: #fff;
}

table tr:nth-child(even) {
	background-color: #ccc;
}

table tr:hover {
	background-color: gray;
	cursor: pointer;
}
</style>
<p></p>
<p></p>
<p></p>
<table>
	<tr>
		<th>번호
		</td>
		<th>이름
		</td>
		<th>학과
		</td>
		<th>학년
		</td>
	</tr>
	<c:choose>
		<c:when test="${STDLIST==NULL }">
			<tr>
				<td colspan="5">데이터가 없습니다.</td>
			</tr>
		</c:when>
		<c:otherwise> <c:forEach items="${STDLIST}" var="dto">
			<tr>
				<td>${dto.st_num }</td>
				<td>${dto.st_name }</td>
				<td>${dto.st_dept }</td>
				<td>${dto.st_grade }</td>
			</tr>
		</c:forEach> </c:otherwise>
	</c:choose>
</table>





