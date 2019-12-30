package com.biz.hello.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View01
 */
@WebServlet("/view/01")
public class View01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String strName=request.getParameter("strName");
		response.setStatus(404);
		/*
		 * 2xx: 정상 데이터 추출중. 기다려라.
		 * 3xx 이전 상태와 유사, 동일하니 너에게 줄것이 없다.
		 * 4xx 요청사항이 잘못 전달되었다. 404==not found. 400==query 데이터를 reques.getParameter
		 *   로 받았는데 문제가 있더라
		 * 5xx: 서버 App이 작동되는 과정에서 Excpetion이 발생을 했다
		 */
		PrintWriter wOut=response.getWriter();
		wOut.println("나는 view01 입니다");
		wOut.printf("나는 %s 입니다", strName);
		wOut.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
