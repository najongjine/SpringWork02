<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %> 
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>병원상세정보</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<style>
	table {
		width: 70%;
		margin: 20px auto;
		border-top: 2px solid #252525;
		border-bottom: 1px solid #ccc;
	}
	table th {
		text-align: left;
		background-color: #f7f7f7;
		color: #3b3b3b;
	}
	
	table th, table td {
		padding: 15px 0 16px 16px;
		border-bottom: 1px solid #ccc;
	}
	
	caption {
		font-size : 25px;
		padding : 10px;
		font-weight: bold;
		color: green;
	}
	
	a.btn {
		border-radius: 3px;
		padding: 5px 11px;
		color: #fff;
		display: inline-block;
		background-color: #A2CD0C;
		border : 1px solid lightgray;
		vertical-align: middle;
		text-decoration: none;
		margin: 5px;
		
	}
	
	div.btn-box{
		width : 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	a.btn:hover {
		/* border: 2px solid black; */
		box-shadow: 5px 5px 8px rgba(80,80,80,0.8)
	}
</style>
<script type="text/javascript">
	$(function(){
		
		$("#btn-update").click(function(){
			if(confirm("병원정보를 수정하시겠습니까?")){
				
				document.location.href = "${rootPath}/hospital/update?id=${hDTO.h_seq}"
			}
		
			
		})
		
		$("#btn-delete").click(function(){
			
			if(confirm("병원정보를 삭제하시겠습니까?")){
				
				let query = "${rootPath}/hospital/delete?h_seq=${hDTO.h_seq}"
				
				document.location.replace(query)
			}
			
		})
		
		$("#btn-hlist").click(function(){
		
			document.location.href = "${rootPath}/hospital/hlist"
		})
		
	})
	
</script>
<body>
<table>

<caption>병원 상세정보</caption>

	<tr>
		<th>No</th><td>${hDTO.h_seq}</td>
		<th>병원이름</th><td>${hDTO.h_name}</td>
	</tr>
	
	<tr>
		<th>주소</th><td>${hDTO.h_addr}</td>
		<th>전화번호</th><td>${hDTO.h_tel}</td>
	</tr>
	
	<tr>
		<th>가격</th><td>${hDTO.h_price}</td>
		<th>기타동물</th><td>${hDTO.h_etc}</td>
	</tr>
	
</table>

<br/><br/>
<div class="btn-box"> 
<a href="javascript:void(0)" class="btn" id="btn-update">수정</a>
<a href="javascript:void(0)" class="btn" id="btn-delete">삭제</a>
<a href="javascript:void(0)" class="btn" id="btn-hlist">목록으로</a>
</div>


</body>
</html>