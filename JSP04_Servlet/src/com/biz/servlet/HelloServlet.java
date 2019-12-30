package com.biz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HttpServlet 클래스를 상속 받아서 생성한 서블릿 클래스.
 * 사용자가 Web을 통해서 req를 보내면 요청을 수신해서 처리할 App의 대문 역활.
 * console 환경에서 main() 있는 클래스와 비슷한 역활 수행.
 * 
 * 1. 사용자가 web brow 를 통해 req를 보내면
 * 2. 서버 컴에 네트웤을 통해서 전송된 데이터를 tomcat이 수신
 * 3. URL의 context 부분을 확인하여 현재 실행되고 있는 프로젝트가 있는지 확인.
 * 4. 프로젝트에 작성되어있는 servlet 클래스들이 있는지 확인
 * 5. servlet의 @webservle()t 항목에 설정된 path를 scan하여
 * 6.사용자의 요청을 해당 클래스의 doGet, doPost method로 전달.
 * 
 * tomcat은 app이 server에 의해 실행되면(run as server)
 * 1. 프로젝트에 담겨있는 모든 *.jsp 파일을 내부적으로 다시 *._jsp.java로
 *   언어컴파일(translate)을 수행.
 * 2. *_jsp.java를 *_jsp.java 파일로 컴파일 수행.
 * 3. *_jsp.java 들을 container에 리스트로 올려두고 req를 대기
 * 
 * -=- 사용자가 생성한 servlet, tomcat이 생성한 _jsp.class 모두
 * 4. servlet 클래스가 있으면 이 클래스들도 모두 컴파일을 수행하고 ㄱ개체로 선언, 생성하여 
 *   container에 리스트로 올려두고 req를 대기
 * 5. web에 req가 오면 이 container 리스트에서 해당 정보를 찾아서 사용자의 요청을 처리.
 * 
 * @WebServlet()
 * 사용자의 req URL|URI 중에 path라고 하는 부분의 ID 값을 설정하는 부분
 * WAS 환경에서는 클래스 이름은 외부로 직접 노출되지 않고 path에 
 * 지정된 값을 통해서 외부 접근을 허용한다.
 * 
 *  id값은 현재 프로젝트에서 유일한 값이어야 한다.
 *  경우에 따라서 /main_path/sub_path/child_path 형식으로 path를 다중으로 설정 할수도 있다.
 *  
 *  
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String strName=request.getParameter("strName");
		String st_dept=request.getParameter("st_dept");
		String st_grade=request.getParameter("st_grade");
		System.out.println(strName);
		
		response.setContentType("text/html;charset=UTF-8");
		//server에서 web으로 데이터를 return하는 통로 오픈.
		//PrintWriter wOut=response.getWriter();
		//wOut.println(strName);
		//wOut.close();
		String sendString="?strName="+URLEncoder.encode(strName,"UTF-8");
		sendString+="&st_dept="+URLEncoder.encode(st_dept,"UTF-8");
		sendString+="&st_grade="+URLEncoder.encode(st_grade,"UTF-8");
		response.sendRedirect("/JSP04_Servlet/View.jsp"+sendString);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
