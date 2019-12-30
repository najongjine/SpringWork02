$(function() {
	
	var cursorArray = ['url("https://i.ibb.co/XZPK3gQ/double-Parrot-1.png"), auto',
        'url("https://i.ibb.co/4FHw5CH/double-Parrot-2.png"), auto',
       'url("https://i.ibb.co/qWfR4Rn/double-Parrot-3.png"), auto',,
       'url("https://i.ibb.co/xsYfT9G/double-Parrot-4.png"), auto',,
       'url("https://i.ibb.co/sPQWrHG/double-Parrot-5.png"), auto',
       'url("https://i.ibb.co/KrtNp4c/double-Parrot-6.png"), auto',
       'url("https://i.ibb.co/SXXRs6d/double-Parrot-7.png"), auto',
       'url("https://i.ibb.co/Jx52qjG/double-Parrot-8.png"), auto',
       'url("https://i.ibb.co/vd1b2d7/double-Parrot-9.png"), auto',
       'url("https://i.ibb.co/qDjwBP8/double-Parrot-10.png"), auto'
       ];
	var i = 0
	setInterval(function() {
		i++
		$('html').css('cursor', cursorArray[i])
		if (i >= cursorArray.length || i < 0) {
			i = 0;
		}
	}, 50);
})