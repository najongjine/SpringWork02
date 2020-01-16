* 그림파일로 별점 매기기 있음.

style은 어떻게 작동하는지 모르겠고,
css에서 selector 태그의 width css를 강제로 변경

input 할시에는 change event를 쓰고
	$("#rb_star").change(function() {
		let star=$(this).val()
		star=star*10
		$("span.star-red").css("width",star+"%")
		$("span#star-v").text($(this).val())
	})

view 할시에는 
	let star="${RBOOK.rb_star}"
	if(star=="") star=1
	else star=parseInt(star)
	star=star*10
	$("span.star-red").css("width",star+"%")


* css 쪽

span.star-box{
		width: 100px;
	}
	span.star-box, span.star-red{
		display: inline-block;
		height: 20px;
		overflow: hidden;
		background: url("${rootPath}/img/star.png") no-repeat;
		/*
		배경 이미지를 width:자동, height:40px;
		*/
		background-size: 100px 40px;
	}
	
	span.star-red{
	/*
	배경 이미지를 채울때 왼쪽 아래 꼭지점을 기준으로 배치하라
	*/
		background-position: left bottom;
		line-height: 0;
		vertical-align: top;
		width: 50%;
	} 

* html 쪽

<span class="star-box">
	<span class="star-red"></span>
</span>
