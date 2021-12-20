package com.importselector;

import com.importselector.components.Dog;
import com.importselector.components.Student;
import com.importselector.components.Tree;
import com.importselector.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(AppConfig.class);

		Dog dog = acac.getBean(Dog.class);
		Student student = acac.getBean(Student.class);
		Tree tree = acac.getBean(Tree.class);
		System.out.println(dog);
		System.out.println(student);
		System.out.println(tree);

		Object dog1 = acac.getBean("com.pole2win.components.Dog");
		Object student1 = acac.getBean("com.pole2win.components.Student");
		Object tree1 = acac.getBean("com.pole2win.components.Tree");
		System.out.println(dog1);
		System.out.println(student1);
		System.out.println(tree1);

		System.out.println(dog == dog1);
		System.out.println(student == student1);
		System.out.println(tree==tree1);
	}
}
