package com.importselector.annotation;

import com.importselector.components.Dog;
import com.importselector.selector.MyImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(value = {
		Dog.class,//直接import有一个普通类，Dog会被实例化并注册到IOC容器
		MyImportSelector.class// MyImportSelector会被实例化并注册到IOC容器
		//MyImportSelector 实现了spring的接口 ImportSelector，根据方法的返回全限定名实例化类并注册到IOC容器
})
public @interface CustomEnableAutoImportBeans {
}
