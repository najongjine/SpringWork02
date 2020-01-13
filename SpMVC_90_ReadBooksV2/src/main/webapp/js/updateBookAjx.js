$(function() {
	$(document).on("click","#updateBook",function() {
		let _b_code=$(this).attr("data-b_code")
		
		$.ajax({
			url:rootPath+"/alter/updateBook",
			data:{_b_code:_b_code},
			type:'GET',
			success:function(result){
				alert("triggered updatebookajx")
				$("#updateBookForm").html("")
				$("#updateBookForm").html(result)
			}
		})
	})
})