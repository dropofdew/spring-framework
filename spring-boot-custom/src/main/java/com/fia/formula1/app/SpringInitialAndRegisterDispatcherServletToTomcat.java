package com.fia.formula1.app;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(HandlesTypesTest.class)
public class SpringInitialAndRegisterDispatcherServletToTomcat implements ServletContainerInitializer {
	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		System.out.println("SpringInitialAndRegisterDispatcherServletToTomcat onStartup.............");
		System.out.println("-----servlet-api中@HandlesTypes注解扫描某个接口的全部实现类的字节码--------" + c);
		//初始化spring容器，web项目使用WebApplicationContex
		AnnotationConfigWebApplicationContext
				acw = new AnnotationConfigWebApplicationContext();
		//Appconfig完成扫描包，将其注册到spring容器中，spring容器即扫描设置路径下bean
		acw.register(Appconfig.class);
////初始化并完成宝扫描，即可使用DI/IOC，getBean()获取扫描包路径下对象实例


		DispatcherServlet dispatcherServlet = new DispatcherServlet();
		//将dispatcherServlet注册到tomcat中，并设置加载，拦截url请求
		ServletRegistration.Dynamic registration = ctx.addServlet("DuplicateCustomTomcatInvoke", dispatcherServlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/dupelicatecustom/*");
	}
}
