package com.fia.f1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class F1Aspect {

	@Pointcut("execution(* com.fia.f1.service..*.*(..))")
//	@Pointcut("execution(* com.f1..service..*.*(..))")
	public void linkExpression() {}

	@Before("linkExpression()")
		public void beforeProcess() {
		System.out.println("before advice begin at " + LocalDateTime.now());
	}

	@After("linkExpression()")
	public void afterProcess() {
		System.out.println("after advice end at " + LocalDateTime.now());
	}

	@Around("execution(* com.fia.f1.dao..*.*(..))")
	public Object aroundProcess(ProceedingJoinPoint pjp) throws Throwable {

		//执行原业务方法之前，执行切面方法
		System.out.println("aroud advice begin " + LocalDateTime.now() );

		Object retVal = pjp.proceed();

		//执行原业务方法之后，执行切面方法
		System.out.println("around advice end " +LocalDateTime.now());

		//必须返回原业务方法结果，封装返回结果为obj类型
		return retVal;

	}
}
