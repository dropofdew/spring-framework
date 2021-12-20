package com.fia.formula1.app;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class CustomTomcatInvoke implements ServletContainerInitializer {
	//init方法需要在tomcat启动时被调用，如同tomcat运行web项目启动时解析xml

	//ServletContext可以理解为tomcat提供的一个上下文
	public void init(ServletContext servletContext) {
		System.out.println("CustomTomcatInvoke onStartup.............");

		//初始化spring容器，web项目使用WebApplicationContex
		AnnotationConfigWebApplicationContext
				acw = new AnnotationConfigWebApplicationContext();
		//Appconfig完成扫描包，将其注册到spring容器中，spring容器即扫描设置路径下bean
		acw.register(Appconfig.class);
////初始化并完成宝扫描，即可使用DI/IOC，getBean()获取扫描包路径下对象实例


		DispatcherServlet dispatcherServlet = new DispatcherServlet(acw);
		//将dispatcherServlet注册到tomcat中，并设置加载，拦截url请求
		ServletRegistration.Dynamic registration = servletContext.addServlet("CustomTomcatInvoke", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/custom/*");
	}


	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		init(ctx);
	}
}
