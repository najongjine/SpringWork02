<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
</head>
<body>
<header>
	<h3>To do List</h3>
</header>

<section>
	<article id="input">
		<form action="">
			<table class="input">
				<tr>
					<th>작성일</th>
					<td><input type="date" name="td_date"></td>
					<th>작성시각</th>
					<td><input type="time" name="td_time"></td>
				</tr>
				<tr>
					<th>할일</th>
					<td colspan="3"><input type="text" name="td_work"></td>
				</tr>
			</table>
		</form>
	</article>
	
	<article id="list">
	</article>
</section>
</body>
</html>