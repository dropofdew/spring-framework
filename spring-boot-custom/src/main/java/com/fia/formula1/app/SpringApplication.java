package com.fia.formula1.app;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class SpringApplication {
	public static void run() throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(9000);
		//让tomcat认为当前项目为web项目
		// 但真实springboot并没有使用addwebapp，采用非web项目方式
		// 而是使用addContext,将onstartup方法中的spring容器初始化和new dispatcherservlet放到这个run的方法体中一起执行
		Context context = tomcat.addWebapp("/root", "E:\\study\\Spring\\spring-boot-custom");
		tomcat.start();
		tomcat.getServer().await();
	}
}
