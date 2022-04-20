package com.tutorialtimposu.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BelajarSpringLoggingAspect {
	
	// setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	// setup pointcut
	@Pointcut("execution(* com.tutorialtimposu.spring.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	@Pointcut("execution(* com.tutorialtimposu.spring.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.tutorialtimposu.spring.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		
		// display method we are calling
		String theMethod = joinPoint.getSignature().getName();
		logger.info("=====> in @Before: calling method: " + theMethod);
		
		// display arguments to the method
		
		// get the arguments
		Object[] args = joinPoint.getArgs();
		
		// loop thru and display arguments
		for (Object obj : args) {
			logger.info("=====> arguments: " + obj);
		}
	}
	
	// add @AfterReturning advice

}
