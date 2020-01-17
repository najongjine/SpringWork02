## Java Config 방식 Spring MVC Project
### 2020-01-17

*web.xml을 대신할 ProjectInit.java 클래스를 생성
-AbstractAnnotationConfigDispatcherServletInitializer 를 상속받기

*root-context.xml을 대신할 RootConfig.java 클래스를 생성
-@Configuration을 클래스에 지정
-method는 없는상태

*servlet-context.xml을 대신할 WebServletConfig.java 클래스를 생성
-@configuration을 클래스에 지정
-@EnableWebMvc를 클래스에 지정
-@ComponentScan()을 클래스에 지정하고 Controller와 Service 패키지를 설정.

-addResourceHandlers() method를 구현하는 코드 추가
-InternalResourceViewResolver 를 생성하고 mapping을 설정하는 코드 추가