package com.topekox.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.topekox.spring.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {		
	}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.topekox.spring.aopdemo.dao.*.get*(..))")
	private void getter() {
		
	}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.topekox.spring.aopdemo.dao.*.set*(..))")
	private void setter() {
		
	}
	
	// create pointcut: include package.. exclude setter/getter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
		
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Execution @Before advice on account()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Perform API analytics");
	}

}
