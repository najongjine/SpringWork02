# Image Gallery Project
* 2020-01-03

### WYSWYG(what you see what you get) Editor
* (summernote) : https://summernote.org/getting-started/
*textarea에 id값을 설정하고 id에 jq를 이용해서 속성을 설정해주면 간편하게 wyswyg방식으로 
 문서를 작성할수 있다.
 
### drag n drop으로 파일올리기
*Drag and drop 을 수행할 box 만들기
* jq의 dragover, drop event를 설정
* e.originalEvent.dataTransfer 로 부터 files 객체를 추출
* files 객체의 0번째 file 객체를 추출

* ajax를 사용해서 서버로 파일을 업로드 수행하고
* 파일 이름등을 response로 되돌려 받아서 form img_file input box에 저장을 하고
* 내용을 form post로 업로드하면 나머지 정보를 db에 저장