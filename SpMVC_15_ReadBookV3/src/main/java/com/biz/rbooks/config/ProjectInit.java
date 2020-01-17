package com.biz.rbooks.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*
 * tomcat이 작동하면서 제일먼저 호출할 클래스
 */
public class ProjectInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] servlet= new Class[]{WebServletConfig.class,MybatisConfig.class};
		return servlet;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		String[] mapping=new String[]{"/","*.do"};
		return mapping;
	}

}
