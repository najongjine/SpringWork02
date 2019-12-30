<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>□□□ My JSP Page □□□</title>
<style>
*,html,body{
margin:0;
padding:0;
}
header {
	background-color: green;
	color: white;
	margin: 0;
	padding: 1rem;
}
ul{
display: flex;
list-style: none;
}
li{
width:100px;
margin-right: 10px;
background-color: green;
}
p{
background-color: cyan;
}
a{
text-decoration: none;

}
nav a:hover {
	font-weight: bold;
	font-style: italic;
}
#p1{ /*id==p1 */
font-size: 50pt;
background-color: blue;
color: white;
}
p.pc{ /* class== pc  .pc 하면 .pc 쓰이는 전체에 적용*/
background-color: red;
color: white;
}
</style>
</head>
<body>
	<header> my page </header>
	<nav>
		<ul>
			<li><a href="#">학생리스트</a></li>
			<li><a href="#">학생검색</a></li>
			<li><a href="#">로그인</a></li>
			<li><a href="#">회원가입</a></li>
		</ul>
	</nav>
	<section>
		<article>
			<p>
				<font size=30pt color=blue>section.article</font>
			</p>
			<p style="font-size: 20pt; color =red; background: yellow">another
				method</p>
			<p>dummy</p>
			<p id="p1">p1 dummy section.article</p>
			<p id="p2">p2 dummy section.article</p>
			<p id="p3" class="pc">p3 dummy section.article</p>
			<p id="p4" class="pc">p4 dummy section.article</p>
			<p id="p5" class="pc">p5 dummy section.article</p>
			<p><a href="https://naver.com/">naver link</a>
			<a href="daum.net">daum</a>
		</article>
	</section>
	<footer>
		<address>CopyRight &copy; najongjin3@hotmail.com</address>
	</footer>
</body>
</html>