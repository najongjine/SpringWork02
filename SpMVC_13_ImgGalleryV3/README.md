# Image Gallery Project
* 2020-01-03

### WYSWYG(what you see what you get) Editor
* (summernote) : https://summernote.org/getting-started/
*textarea에 id값을 설정하고 id에 jq를 이용해서 속성을 설정해주면 간편하게 wyswyg방식으로 
 문서를 작성할수 있다.
 
### drag n drop으로 파일올리기
1Drag and drop 을 수행할 box 만들기
2 jq의 dragover, drop event를 설정
3 e.originalEvent.dataTransfer 로 부터 files 객체를 추출
4 files 객체의 0번째 file 객체를 추출

5 ajax를 사용해서 서버로 파일을 업로드 수행하고
6 파일 이름등을 response로 되돌려 받아서 form img_file input box에 저장을 하고
7 내용을 form post로 업로드하면 나머지 정보를 db에 저장

### Drag n drop으로 여러개 파일 올리기
* 1~3까지는 single file upload와 동일
4. files 객체에 담긴 모든 file 객체를 formData에 append
5. ajax를 사용해서 서버로 업로드 수행하고
6. 컨트롤러는 수신된 파일들을 서버에 저장하고 
7. 저장된 파일이름을 리스트로 생성하고 
8. 생성된 파일이름 리스트와 리스트르 표현할 jsp를 rendergin 하여 다시 return 하고
9. ajax success 코드에서ㅗ는 return받은 html코드를
10. 리스트를 표현할 box에 보인다.

### 이때 리스트를 만들때
* hidden 으로 파일리스트를 담을 input box를 만들고  
* 각각의 파일이름을 input box에 value에 추가해둔다

### 저장을 하면
*다시 컨트롤러에서는 본문 text와 함께 hidden input box에 담긴 파일이름을 수신하는데
* String[] mFile: 문자열 배열로 수신하면 된다. 

### form에서 같은 tag에 다중값을 담아서 controller 전달하기

#### 1. List<String>형식으로 전달하기
* form에서 같은 이름의 tag에 다중의 값을 담고
* <input name="title" value="1번">
*	<input name="title" value="2번">
*	<input name="title" value="3번">

* Controller에서
* String[] title 형식으로 매개변수 설정하여 받기
* VO 내부에서 List<String> title 변수 설정해서 받기

#### 2. List<subVO> 를 포함한 MainVO에 한꺼번에 받기
* form에서 같은 이름의 tag에 다중의 값을 담고
* <input name="main[0]" value="1번">
*	<input name="main[1]" value="2번">
*	<input name="main[2]" value="3번"> 


### HttpSession
* http는 특성상 req가 이루어지고 결과를 response 하게되면 web browser와 server간에 어떠한 정보도 남지 않게된다.
 statusless.
* 통신에서는 같은 client에서 같은 주소로 서버에 자주 req를 수행하는 경우가 많다.
* 이때 client가 요청한 req에대한 정보를 server가 참조하고 싶을때가 있다. (login 정보)
* 과거에는 쿠키를 사용. 쿠키 만들어서 보내고 req때 쿠키정보를 분석함.
* Session 도입됨. java기반 서버(was) 에선 httpsession 클래스를 이용.
*서버는 필요할때 httpsession 객체에 attribute를 추가하면 java에서 사용할수있는
 어떤 데이터라도 sessikon 형 데이터로 만들수 있다.
* httpSession.setattribute("member",membervo) 형태로 코딩을 하게되면 memberVO객체에 담긴 모든 데이터가 서버 기억장치 어딘가에 보관되고 , member라는 이름으로 session id가 생성된다.
* 이때 session id는 자체적으로 특별한 방법으로 암호화된 값으로 변환된다.
* 서버에서 res를 수행하면 자동으로 res body에 이 session id값이 추가되어 client로 보내진다.
* client는 수신된 res정보에 session id가ㅣ 있으면 cookie영역에 임시보관을 한다.
* 이후에 client에서 req를 보낼때 이 session id를 첨가하여 서버로 보낸다.
* 서버(spring)에서는 req정보에 sessino id가 있으면 해당 session 객체를 메모리에서 찾아보고 session id가 유효하면
 그 객체를 controller의 method에 주입한다.
* controller의 method에서는 HttpSession 형식의 매게변수를 선언해두면 해당 객체에 session 객체값이 겸겨있어서 코드에서
사용할수 있다. 