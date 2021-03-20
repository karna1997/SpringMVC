package com.jbk.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//Dispatcher Servlet
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		  System.out.println("getRootConfigClasses()-----");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfigClasses()-----");
		return new Class[]{WebConfig.class,HibernateConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletmapping()-----");
		return new String[]{"/"};
}
}