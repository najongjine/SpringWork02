<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>개인정보처리방침</title>
<link rel="stylesheet" href="${rootPath}/css/main.css?ver=20191224001" type="text/css">
</head>
<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

section {
    display: block;
}
.privacy_title > p {
    padding-bottom: 8px;
    margin: 8px auto;
    width: 70%;
    border-bottom: 3px solid #A2CD0C;
    font-size: 30px;
    margin: 10px auto;
}
li {
	list-style: none;
}

.privacy_atc{
	width : 100%;
	display: flex;
	justify-content: center;
	height: 500px;
	overflow: auto;

}

.privacy_text {
	width: 70%;
	justify-content: center;
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 3em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    overflow: auto;
    white-space: pre-line;
    
}

</style>
<body>

	<div id="head">
		<header>
			<a class="logo-img" href="http://192.168.123.29:8080/pets/"><img
				src="${rootPath}/images/logo.png" width=200 alt="로고이미지"></a>
		</header>

		<div id="userimg">
			<p>
				<a href="${rootPath}/member/login"><img
					src="${rootPath}/images/userimg.png" width=62 alt="유저이미지"></a>
			</p>
		</div>
		<nav>
			<ul class="main-nav">
				<li><a href="http://192.168.123.29:8080/pets/info">소개</a></li>
				<li><a href="${rootPath}/">병원찾기</a></li>
				<li><a href="http://192.168.123.18:8080/pet/bloodtest/allList">피검사</a></li>
				<li><a href="http://192.168.123.18:8080/pet/simplediag/main">상태보고서</a></li>
				<li><a href="http://192.168.123.29:8080/pets/community/list">커뮤니티</a></li>
			</ul>
		</nav>
		<img class="bannerimg" src="${rootPath}/images/privacy.png" width=100%
			alt="배너이미지">
	</div>
	<section class="news_section">
		<article class="privacy_title">
		    <p>개인정보처리방침</p>
		<div class="privacy_atc">
		    <ul class="privacy_text">
	        	정보통신망법 규정에 따라 '우리애를부탁해'에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 수집 및 이용목적, 개인정보의 보유 및 이용기간을 안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.

				1. 수집하는 개인정보
				이용자는 회원가입을 하지 않아도 병원 정보 검색, 병원 정보 보기 등 대부분의 우리애를부탁해 서비스를 회원과 동일하게 이용할 수 있습니다. 이용자가 메일, 캘린더, 카페, 블로그 등과 같이 개인화 혹은 회원제 서비스를 이용하기 위해 회원가입을 할 경우, 우리애를부탁해는 서비스 이용을 위해 필요한 최소한의 개인정보를 수집합니다.
				
				회원가입 시점에 우리애를부탁해가 이용자로부터 수집하는 개인정보는 아래와 같습니다.
				- 회원 가입 시에 ‘아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호’를 필수항목으로 수집합니다. 만약 이용자가 입력하는 생년월일이 만14세 미만 아동일 경우에는 법정대리인 정보(법정대리인의 이름, 생년월일, 성별, 중복가입확인정보(DI), 휴대전화번호)를 추가로 수집합니다. 그리고 선택항목으로 이메일 주소, 프로필 정보를 수집합니다.
				- 단체아이디로 회원가입 시 단체아이디, 비밀번호, 단체이름, 이메일주소, 휴대전화번호를 필수항목으로 수집합니다. 그리고 단체 대표자명을 선택항목으로 수집합니다.
				서비스 이용 과정에서 이용자로부터 수집하는 개인정보는 아래와 같습니다.
				NAVER 내의 개별 서비스 이용, 이벤트 응모 및 경품 신청 과정에서 해당 서비스의 이용자에 한해 추가 개인정보 수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우에는 해당 개인정보 수집 시점에서 이용자에게 ‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’에 대해 안내 드리고 동의를 받습니다.
				
				서비스 이용 과정에서 IP 주소, 쿠키, 서비스 이용 기록, 기기정보, 위치정보가 생성되어 수집될 수 있습니다. 또한 이미지 및 음성을 이용한 검색 서비스 등에서 이미지나 음성이 수집될 수 있습니다.
				구체적으로 1) 서비스 이용 과정에서 이용자에 관한 정보를 자동화된 방법으로 생성하여 이를 저장(수집)하거나,
				2) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다. 서비스 이용 과정에서 위치정보가 수집될 수 있으며,
				우리애를부탁해에서 제공하는 위치기반 서비스에 대해서는 '우리애를부탁해 위치정보 이용약관'에서 자세하게 규정하고 있습니다.
				이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수도 있습니다.
				3) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다. 서비스 이용 과정에서 위치정보가 수집될 수 있으며,
				우리애를부탁해에서 제공하는 위치기반 서비스에 대해서는 '우리애를부탁해 위치정보 이용약관'에서 자세하게 규정하고 있습니다.
				이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수도 있습니다.
				4) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다. 서비스 이용 과정에서 위치정보가 수집될 수 있으며,
				우리애를부탁해에서 제공하는 위치기반 서비스에 대해서는 '우리애를부탁해 위치정보 이용약관'에서 자세하게 규정하고 있습니다.
				이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수도 있습니다.
				5) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다. 서비스 이용 과정에서 위치정보가 수집될 수 있으며,
				우리애를부탁해에서 제공하는 위치기반 서비스에 대해서는 '우리애를부탁해 위치정보 이용약관'에서 자세하게 규정하고 있습니다.
				이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수도 있습니다.
				6) 이용자 기기의 고유한 정보를 원래의 값을 확인하지 못 하도록 안전하게 변환하여 수집합니다. 서비스 이용 과정에서 위치정보가 수집될 수 있으며,
				우리애를부탁해에서 제공하는 위치기반 서비스에 대해서는 '우리애를부탁해 위치정보 이용약관'에서 자세하게 규정하고 있습니다.
				이와 같이 수집된 정보는 개인정보와의 연계 여부 등에 따라 개인정보에 해당할 수 있고, 개인정보에 해당하지 않을 수도 있습니다.
            </ul>
         </div>
        </article>          
    </section>

    <%@ include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>