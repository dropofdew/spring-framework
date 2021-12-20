package com.fia.formula1.test;

import com.fia.formula1.web.IndexServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class Test {
	public static void main(String[] args) throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8888);
		tomcat.start();
		IndexServlet indexServlet = new IndexServlet();
		//让tomcat认为当前项目为web项目，设置tomcat工作目录 docBase具体物理路径
		Context context = tomcat.addWebapp("/root", "E:\\study\\Spring\\spring-boot-custom");
		//
		tomcat.addServlet("/root", "index", indexServlet);
		context.addServletMappingDecoded("/index","index");
		tomcat.getServer().await();

	}
}
