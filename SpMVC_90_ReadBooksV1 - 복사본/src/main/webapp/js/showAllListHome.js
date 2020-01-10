$(function() {
	$(".readBookVOBody").click(function(e) {
		let rb_seq = $(this).attr("data-rb_seq")
		let b_code=$(this).attr("data-b_code")
		let m_id=$(this).attr("data-m_id")
		$.post("${rootPath}/rest/image_delete",
		{rb_seq:rb_seq, b_code:b_code, m_id:m_id},
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