package com.pole2win.spi.config;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.util.List;

public class CustomAutoConfigurationRegistrar implements ImportBeanDefinitionRegistrar,
		BeanClassLoaderAware {

	@Autowired
	private ClassLoader beanClassLoader;

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.beanClassLoader = classLoader;
	}

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		List<String> classStringList = SpringFactoriesLoader.loadFactoryNames(CustomAutoConfiguration.class, beanClassLoader);

		classStringList.forEach(s -> System.out.println("SpringFactoriesLoader加载全限定名类为"+s));

		if (classStringList.isEmpty()) {
			return;
		}

		for (String classFullName : classStringList) {
			try {
				Class<?> loadClass = beanClassLoader.loadClass(classFullName);
				String simpleName = loadClass.getSimpleName();
				System.out.println("ClassLoader加载全限定名类后获取的简单类名为："+simpleName);
				if (registry.containsBeanDefinition(simpleName)) {
					continue;
				}
				//无参构造器创建beandefinition
				BeanDefinition bd = BeanDefinitionBuilder.rootBeanDefinition(classFullName).getBeanDefinition();
				//注册需要简单类名和bean定义
				registry.registerBeanDefinition(simpleName,bd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
