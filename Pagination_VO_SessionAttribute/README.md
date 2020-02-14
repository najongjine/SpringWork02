SesseionAttribute 사용해서 페이지내이션

VO 만들어주고


controller 맨 윗쪽에 @SessionAttribute("myVO")

필드변수 선언부에
@modelattribute("myVO")
public makeVO(){
return new MyVO();
}
modelattribute 심어줌.

controller 파라매터에 @modelAttribute VO 걸어줌

nav쪽에 searchVO에 걸려있는 값을 강제 상수 지정해서 전체 리스트 보기로 설정
<a href="${rootPath}/readbook/simpleViewList?searchOption=bnameSearch&inputStr="> 메인화면으로 </a> 