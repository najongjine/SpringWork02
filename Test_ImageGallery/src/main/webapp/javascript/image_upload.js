var file_up = function(formData) {

	$.ajax({
		url : rootPath + "/rest/file_up",
		method : 'POST',
		data : formData,

		/* 파일업로드 필수옵션 */
		processData : false,
		contentType : false,

		success : function(result) {
			if (result == 'FAIL') {
				alert("파일업로드 오류")
			} else {
				/*
				 * img_file 이란 id는 form:form 태그의 img_upload.jsp의 path와 이름이 같음
				 * $("#img_file").val(result) 이 문장이 path 부분의 img_file에 값을 채워넣어줌
				 * img_upload.jsp 에서 저장 버튼을 누르면 세팅된 값을 post로 넘겨서 controller에서 파일
				 * 이름만 DB에 저장
				 */
				$("#img_file").val(result)
				$("#img_view").css("display", "block")
				$("#img_view").attr("src", rootPath + "/images/" + result)
				$("#d_d_box h3").css("display", "none")
			}
		},
		error : function() {
			alert("서버통신 오류")
		}
	})
}