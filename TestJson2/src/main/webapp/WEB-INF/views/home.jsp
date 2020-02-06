<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
	var vo="${testVO}"
	var voSingleElement="${testVO}"
	var list=${testVO.testList}
	$.each(list, function( index, value ) {
		//alert(value)
	})
})
</script>
</head>
<body>
2019. 12. 30.
</body>
</html>