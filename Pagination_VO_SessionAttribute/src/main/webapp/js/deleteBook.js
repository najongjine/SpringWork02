$(function() {
	$(document).on("click","#deleteBook",function() {
		let _rb_bcode=$(this).attr("data-b_code")
		alert("works")
		$.post(rootPath+"/rest/deleteBook",
			{_rb_bcode:_rb_bcode},
			function(result) {
			if(result=="OK"){
				alert("OK")
				document.location.replace(rootPath+"/readbook/simpleViewList")
			}
			else{
			alert("파일을 삭제할수 없음")
			document.location.replace(rootPath+"/readbook/viewAllBooks")
			}
		})
	})
})