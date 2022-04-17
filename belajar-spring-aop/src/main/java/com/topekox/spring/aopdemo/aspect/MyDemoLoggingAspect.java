package com.topekox.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where add all of our rellated advices for logging
	
	// lets start with an @Before Advice
	
	@Before("execution(public void com.topekox.spring.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>>> Execution @Before advice on account()");
	}

}
