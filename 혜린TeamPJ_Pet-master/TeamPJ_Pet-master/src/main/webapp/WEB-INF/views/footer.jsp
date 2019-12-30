<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#footer{
	background-color: #A2CD0C;
}

#footer-img {
	position: absolute;
	top: 20px;
	left: 10px;
}

.footer-menu{
	position: relative;
	display: flex;
	list-style: none;
	justify-content: flex-end;
	padding: 1rem;
}

.footer-menu li a {
	display: block;
	color: inherit;
	padding: 8px 12px;
	text-decoration: none;
}

.addr {
	text-align: center;
}
</style>
<body>
<footer id="footer">
        
	<div class="footer-menu">
    	<div id="footer-img">
     		<img src="${rootPath}/images/logo.png" width=80 alt="로고이미지">
   		</div>
    
    	<li><a href="${rootPath}/privacy">개인정보처리방침</a></li>
    	<li><a href="#">이용약관</a></li>
    	<li><a href="#">개선제안</a></li>
   	</div>
        
    <div class="addr">
    	<address>광주광역시 북구 경양로 170(중흥동) 한경빌딩(구 남양건설) 5층 한국경영원 인재개발원</address>
        <p>By team Take Care Of My Pet |Hyerin Yu|SeJin Lee|JongJin Park</p>
        <address>CopyRight &copy; 2019 All right reserved </address>
   	</div>

</footer>
</body>
</html>