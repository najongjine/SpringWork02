* xml 방식으로 받을때는 tostring, 넣어주고, 정 안되면 get setter 셋팅. class 선언은 public.
 xml 방식은 restTemplate 으로 받는게 맞음.
 
* Json으로 받을땐 상위 json 클래스를 잘 파악해야함. { a{ }  } 이렇게 되있을시 { } 클래스는 걍 아무 리음으로 만들어 주면됨.
 그리고 하위 클래스들은 똑같은 이름으로 해주고 되도록 @jsonproperty 붙여줌. 재일 중요한게  맨 밑단 클래스임.
  밑단 클래스의 프로퍼티들은 꼭 @jsonproperty들을 붙여서 a{ a:a, b:b, c:c} 이렇게 있다면 @jsonprty("a") String a
  이런식으로 해줘야함.
  선언은 private으로 해줘도 무방.
 
* 공공DB에서 '지역기반 관광정보조회' 여기서 cat1~cat3 부분만 잘 설정해 주면 됨.
 그럼 해당취미 전체 목록 가져올수 있고, 지도좌표 사진 그런거 다 들어있음.
 
 