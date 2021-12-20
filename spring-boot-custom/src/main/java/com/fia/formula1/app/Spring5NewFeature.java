package com.fia.formula1.app;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Spring5NewFeature implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("Spring5NewFeature onStartup.............");
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(Appconfig.class);

		// Create and register the DispatcherServlet
		//new DispatcherServlet的父类构造器FrameworkServlet 会执行refresh，完成spring容器初始化
		//并未在AnnotationConfigWebApplicationContext无参构造器后 马上执行spring容器初始化
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("Spring5NewFeature", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/spring5/*");
	}
}
