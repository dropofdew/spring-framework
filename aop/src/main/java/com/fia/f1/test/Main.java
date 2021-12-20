package com.fia.f1.test;

import com.fia.f1.app.Config;
import com.fia.f1.dao.UserDao;
import com.fia.f1.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		UserService userService = ac.getBean(UserService.class);
		UserDao userDao = ac.getBean(UserDao.class);
		userService.query();
		userDao.query();
	}
}
