package com.importselector.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//返回的全限定名的类，会被实例化并注册到IOC容器，默认是单例的
		return new String[]{"com.pole2win.components.Student", "com.pole2win.components.Tree"};
	}
}
