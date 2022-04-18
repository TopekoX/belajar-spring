package com.topekox.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where add all of our rellated advices for logging
	
	// lets start with an @Before Advice
	
	@Pointcut("execution(* com.topekox.spring.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {		
	}
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Execution @Before advice on account()");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Perform API analytics");
	}

}
