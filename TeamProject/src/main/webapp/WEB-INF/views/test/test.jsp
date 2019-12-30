<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<input name="test1" value="${testDTO.test1 }">
<input name="test2" value="${testDTO.test2 }">
<p>${testDTO.test1 }</p>
<p>${testDTO.test2 }</p>
<button>save</button>
</form>
</body>
</html>
