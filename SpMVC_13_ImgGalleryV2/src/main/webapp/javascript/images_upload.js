var files_up = function(formData) {
	alert("ajax files up called")
	$.ajax({
		url : rootPath + "/image/files_up",
		method : 'POST',
		data : formData,

		/* 파일업로드 필수옵션 */
		processData : false,
		contentType : false,

		success : function(result) {
			if (result == 'FAIL') {
				alert("파일업로드 오류")
			} else {
				$("#d_d_box").html(result)
			}
		},
		error : function() {
			alert("서버통신 오류")
		}
	})
}