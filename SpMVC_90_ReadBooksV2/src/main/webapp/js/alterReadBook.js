$(function() {
	$(document).on("click","#postDelete",function() {
		let _rb_seq=$(this).attr("data-rb_seq")
		let m_id=$(this).attr("data-m_id")
		let rb_bcode=$(this).attr("data-b_code")
		/*if(memberVO_m_id!=m_id){
			return false
		}*/
		alert("works")
		/*if(modal=='UPDATE'){
			alert(modal)
			$(".update-form").css("display","block")
		} */
		//document.location.href = rootPath+"/alter/updateReadBook?m_id="+m_id+"&rb_seq="+rb_seq
		$.post(rootPath+"/rest/deleteReadBook",
			{_rb_seq:_rb_seq},
			function(result) {
			if(result=="OK"){
				alert("OK")
				document.location.replace(rootPath+"/readbook/simpleViewList")
			}
			else{
			alert("파일을 삭제할수 없음")
			document.location.replace(rootPath+"/readbook/simpleViewList")
			}
		})
	})
	
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
			document.location.replace(rootPath+"/readbook/simpleViewList")
			}
		})
	})
})