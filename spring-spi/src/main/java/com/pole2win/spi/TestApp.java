package com.pole2win.spi;


import com.pole2win.spi.components.*;
import com.pole2win.spi.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);

		try {
			test1(acac);
		} catch (Exception e) {
			e.printStackTrace();
		}

		test2(acac);

		//关闭容器
		acac.close();
	}

	private static void test2(AnnotationConfigApplicationContext acac) {
		Driver driver = acac.getBean(Driver.class);
		System.out.println(driver.getName());
		SpiInterface spiImpl = acac.getBean(SpiInterface.class);
		System.out.println(spiImpl.get());
	}

	private static void test1(AnnotationConfigApplicationContext acac) {
		Dog dog = acac.getBean(Dog.class);
		Student student = acac.getBean(Student.class);
		Tree tree = acac.getBean(Tree.class);
		System.out.println(dog);
		System.out.println(student);
		System.out.println(tree);

		//由于注册器使用简单名称向IOC容器注册bean，因此通过spring获取bean使用简单名称
		Object dog1 = acac.getBean("Dog");
		Object student1 = acac.getBean("Student");
		Object tree1 = acac.getBean("Tree");
		System.out.println(dog1);
		System.out.println(student1);
		System.out.println(tree1);

		System.out.println(dog == dog1);
		System.out.println(student == student1);
		System.out.println(tree==tree1);
	}
}
