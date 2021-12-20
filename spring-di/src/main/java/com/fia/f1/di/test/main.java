package com.fia.f1.di.test;

import com.fia.f1.di.app.AppConfig;
import com.fia.f1.di.dao.UserDao;
import com.fia.f1.di.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationConfigApplicationContext ac2 = new AnnotationConfigApplicationContext();

		UserService userService = ac.getBean(UserService.class);
		userService.query();

		try {
			//ac未扫描dao下包,No qualifying bean of type 'com.fia.f1.dao.UserDao' available
			UserDao userDao = ac.getBean(UserDao.class);
			userDao.query();
		} catch (BeansException e) {
			e.printStackTrace();
		}

		ac.register(UserDao.class);
		//有残annotationConfigApplicationContext构造器在内部会主动调用refresh方法，refresh真正完成spring容器初始化
		//生成了springbean对象
		ac.getBean(UserDao.class).query();

		ac2.register(UserService.class);
		//无参annotationConfigApplicationContext必须手动refresh
		ac2.refresh();
		UserService userService2 = ac2.getBean(UserService.class);
		userService2.query();


	}
}
