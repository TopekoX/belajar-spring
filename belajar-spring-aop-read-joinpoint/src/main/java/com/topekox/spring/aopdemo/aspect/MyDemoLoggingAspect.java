package com.topekox.spring.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.topekox.spring.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Before("com.topekox.spring.aopdemo.aspect.TopekoxAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=====>>> Execution @Before advice on account()");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("Method: " + methodSignature);
		
		// display method arguments
		
		// get args
		Object[] args = joinPoint.getArgs();
		
		for (Object tempObj : args) {
			System.out.println(tempObj);
			
			if (tempObj instanceof Account) {
				// downcast and print Account specific stuf
				Account account = (Account) tempObj;
				
				System.out.println("Account name: " + account.getName());
				System.out.println("Account level: " + account.getLevel());
			}
		}
		
	}
		
}
