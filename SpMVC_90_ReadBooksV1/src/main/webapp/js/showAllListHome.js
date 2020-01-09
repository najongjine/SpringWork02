$(function() {
	$(".readBookVOBody").click(function(e) {
		let rb_seq = $(this).attr("data-id")
		alert("clicked")
		/*
		주소창에 /dept/view를 입력하여 서버에 전송하라
		id변수에 값을실어서 보내라
		 */
		document.location.href = rootPath+"/bloodtest/view?id=" + id
	})

})