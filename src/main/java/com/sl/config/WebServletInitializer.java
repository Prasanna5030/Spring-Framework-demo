package com.sl.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class WebServletInitializer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(AppConfig.class);
		DispatcherServlet ds = new DispatcherServlet(context);
		
		ServletRegistration.Dynamic myDispatcherServlet= servletContext.addServlet("dispatcherServlet", ds);
		myDispatcherServlet.setLoadOnStartup(1);
		myDispatcherServlet.addMapping("/");
		
	}

}
