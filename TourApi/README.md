* xml 방식으로 받을때는 tostring, 넣어주고, 정 안되면 get setter 셋팅. class 선언은 public.
 xml 방식은 restTemplate 으로 받는게 맞음.
 
* Json 에선  VO 구조짜기가 완전히 틀려짐. 맨 위 VO는 아무이름이나 하고 시작. 문제가 맨 밑단 데이터set을 받을때
 json list 방식으로 오면 괜찬은데, 그냥 { a:a, b:b, c:c} 이렇게 오면 a,b,c 이렇게 밑단 VO3개를 일일히 다 만들어줘야함. 
 
 