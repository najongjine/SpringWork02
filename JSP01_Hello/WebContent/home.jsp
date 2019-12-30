<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//여기는 jsp파일내에 java코드를 작성하는 영역
	int num1 = 30;
	int num2 = 40;
	int sum = num1 + num2;

	System.out.println(sum);
%>
<!DOCTYPE html>
<html>
<!--  head tag는 페이지에 대한 정보등을 기록하는 부분
웹페이지에 표시되지는 않지만 웹페이지에 어떤 것을 표시하기 위한 다양한 설정등을 기록하는 부분 -->
<head>
<meta charset="UTF-8">
<title>나의 첫번째 홈페이지</title>
</head>
<!--  디자인과 관련된 문서표시를 하는 부분 -->
<body>
	<h2>나는 home.jsp 입니다</h2>
	<h3>반갑습니다</h3>
	<h4>test</h4>
	<h4><%=sum%></h4>
	<!--  웹페이지에선 enter 의미가 없다.
	한개의 문단 내의 문자열이 매우 커서 한줄에 표시가 되지 않을때는 자동으로 다음줄로 넘겨져서 표시가 됨.
	이걸 Auto Word Wrap 이라고 한다. 
	/br==break의 약자-->
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do</br>
		eiusmod tempor incididunt ut labore et dolore magna aliqua. Nisl</br>
		tincidunt eget nullam non. Quis hendrerit dolor magna eget est lorem</br>
		ipsum dolor sit. Volutpat odio facilisis mauris sit amet massa.
		Commodo odio aenean sed adipiscing diam donec adipiscing tristique. Mi
		eget mauris pharetra et. Non tellus orci ac auctor augue. Elit at
		imperdiet dui accumsan sit. Ornare arcu dui vivamus arcu felis.
		Egestas integer eget aliquet nibh praesent. In hac habitasse platea
		dictumst quisque sagittis purus. Pulvinar elementum integer enim neque
		volutpat ac. Senectus et netus et malesuada. Nunc pulvinar sapien et
		ligula ullamcorper malesuada proin. Neque convallis a cras semper
		auctor. Libero id faucibus nisl tincidunt eget. Leo a diam
		sollicitudin tempor id. A lacus vestibulum sed arcu non odio euismod
		lacinia. In tellus integer feugiat scelerisque. Feugiat in fermentum
		posuere urna nec tincidunt praesent. Porttitor rhoncus dolor purus non
		enim praesent elementum facilisis. Nisi scelerisque eu ultrices vitae
		auctor eu augue ut lectus. Ipsum faucibus vitae aliquet nec
		ullamcorper sit amet risus. Et malesuada fames ac turpis egestas sed.
		Sit amet nisl suscipit adipiscing bibendum est ultricies. Arcu ac
		tortor dignissim convallis aenean et tortor at. Pretium viverra
		suspendisse potenti nullam ac tortor vitae purus. Eros donec ac odio
		tempor orci dapibus ultrices. Elementum nibh tellus molestie nunc. Et
		magnis dis parturient montes nascetur. Est placerat in egestas erat
		imperdiet. Consequat interdum varius sit amet mattis vulputate enim.
		Sit amet nulla facilisi morbi tempus. Nulla facilisi cras fermentum
		odio eu. Etiam erat velit scelerisque in dictum non consectetur a
		erat. Enim nulla aliquet porttitor lacus luctus accumsan tortor
		posuere. Ut sem nulla pharetra diam. Fames ac turpis egestas maecenas.
		Bibendum neque egestas congue quisque egestas diam. Laoreet id donec
		ultrices tincidunt arcu non sodales neque. Eget felis eget nunc
		lobortis mattis aliquam faucibus purus. Faucibus interdum posuere
		lorem ipsum dolor sit.</p>
	<p>국가는 전통문화의 계승·발전과 민족문화의 창달에 노력하여야 한다. 제3항의 승인을 얻지 못한 때에는 그 처분 또는
		명령은 그때부터 효력을 상실한다. 이 경우 그 명령에 의하여 개정 또는 폐지되었던 법률은 그 명령이 승인을 얻지 못한 때부터
		당연히 효력을 회복한다. 국민의 모든 자유와 권리는 국가안전보장·질서유지 또는 공공복리를 위하여 필요한 경우에 한하여 법률로써
		제한할 수 있으며, 제한하는 경우에도 자유와 권리의 본질적인 내용을 침해할 수 없다. 국회는 국민의 보통·평등·직접·비밀선거에
		의하여 선출된 국회의원으로 구성한다.</p>
</body>
</html>