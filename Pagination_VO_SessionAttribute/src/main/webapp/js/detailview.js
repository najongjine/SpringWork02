$(function() {
	$(document).on("click",".readbook",function() {
		let rb_seq=$(this).attr("data-rb_seq")
		let rb_bcode=$(this).attr("data-b_code")
		let record_m_id=$(this).attr("data-rb_mid")
		if(memberVO_m_id!=record_m_id){
			return false
		}
		$.ajax({
			url:rootPath+"/alter/updateReadBookAjx",
			data:{rb_seq:rb_seq},
			type:'POST',
			success:function(result){
				$("#updateForm").html("")
				$("#updateForm").html(result)
			}
		})
	})
})