$(function() {
	$(document).on("click","#postDelete",function() {
		let _rb_seq=$(this).attr("data-rb_seq")
		let m_id=$(this).attr("data-m_id")
		/*if(memberVO_m_id!=m_id){
			return false
		}*/
		alert("works")
		/*if(modal=='UPDATE'){
			alert(modal)
			$(".update-form").css("display","block")
		} */
		//document.location.href = rootPath+"/alter/updateReadBook?m_id="+m_id+"&rb_seq="+rb_seq
		$.post(rootPath+"/alter/deleteReadBook",
			{_rb_seq:_rb_seq},
			function(result) {
			if(result=="OK"){
				document.location.replace(document.location.href)
			}
			else{
			alert("파일을 삭제할수 없음")
			document.location.replace(document.location.href)
			}
		})
	})
})