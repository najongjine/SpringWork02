$(function() {
	var calc = function() {
		let price = parseInt($("#io_price").val())
		let qty = parseInt($("#io_qty").val())
		let total = price * qty
		$("#io_total").val(total)
	}
	$("#btn-save").click(function() {
		let dCode = $("#io_dcode").val()
		if (dCode == "") {
			alert("거래처 코드는 반드시 입력해야 합니다!!")
			$("#io_dcode").focus()
			return false
		}
		let pCode = $("#io_pcode").val()
		if (pCode == "") {
			alert("상품 코드는 반드시 입력해야 합니다!!")
			$("#io_pcode").focus()
			return false
		}
		if (confirm("save?")) {
			$("form").submit()
		}
	})
	$("#io_price").on("change keyup paste input propertychange", calc)
	$("#io_qty").on("change keyup paste input propertychange", calc)
	$("#io_dcode").keypress(function(e) {
		if (e.keyCode == 13) {
			// 거래처코드 inputbox에 입력된 값을 추출
			let strText = $(this).val()
			let query = rootPath
			query += "/dept/search?strText=" + strText

			let status = "toolbar=no,"
			status += "scrollbars=yes,"
			status += "resizable=no,"
			status += "top=200,"
			status += "left=200,"
			status += "width=400,"
			status += "height=400"
			window.open(query, "_blank", status)
		}
	})
	/*
	 * 어떤 글자가 입력 되었는가 event의 keycode라는 속성에 문자의 ascii 값이 저장되어 전달됨
	 */
	$("#io_pcode").keypress(function(event) {
		if (event.keyCode == 13) {
			let str = $(this).val()
			let query = rootPath
			query += "/product/search?strText=" + str
			let status = "toolbar=no,"
			status += "scrollbars=yes,"
			status += "resizable=no,"
			status += "top=300,"
			status += "width=700,"
			status += "height=500"
			window.open(query, "_blank", status)
		}
	})
})