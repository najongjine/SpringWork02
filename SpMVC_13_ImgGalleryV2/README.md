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