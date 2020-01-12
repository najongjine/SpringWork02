$(function() {
	$(document).on("click","#insertBook",function() {
		alert("triggered insertbookajx")
		$.ajax({
			url:rootPath+"/alter/insertBook",
			type:'GET',
			success:function(result){
				$("#insertBookForm").html("")
				$("#insertBookForm").html(result)
			}
		})
	})
})