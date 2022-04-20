package com.topekox.spring.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	// create logger
	Logger logger = Logger.getLogger(getClass().getName());
	
	// add @around
	@Around("execution(* com.topekox.spring.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object arroundGetFortune(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		// print which method we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @Arround on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method
		Object result = proceedingJoinPoint.proceed();
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		logger.info("\n=====> Duration: " + duration / 1000.0 + " seconds");
				
		return result;
	}
	
	// add @after finnaly
	@After("execution(* com.topekox.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		// print which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @After (finnaly) on method: " + method);

	}
	
	// add @afterThrowing
	@AfterThrowing(
				pointcut = "execution(* com.topekox.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
				throwing = "theExcep"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint,
			Throwable theExcep) {
		
		// print which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @AfterThrowing on method: " + method);
		
		// log the exception
		logger.info("\n======>>> The Exception is : " + theExcep);
	}
	
	// add new advice for @AfterReturning on the findAccount() method
	@AfterReturning(
				pointcut = "execution(* com.topekox.spring.aopdemo.dao.AccountDAO.findAccounts(..))",
				returning = "result"
			)
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, 
			List<Account> result) {
		
		// print out which method we are advising on
		String method = joinPoint.getSignature().toShortString();
		logger.info("\n======>>> Executing @AfterReturning on method: " + method);
		
		
		// print out the result of the method call
		logger.info("\n======>>> Result is : " + result);
		
		// lets modifify the data :-)
		
		// convert the account name to upppercase
		convertToUpperCase(result);
		
		logger.info("\n======>>> Result is : " + result);

	}
	
	private void convertToUpperCase(List<Account> result) {
		
		// loop throught account
		for(Account tempAccount : result) {
			
			// set uppercase the name
			String theUpperCaseName = tempAccount.getName().toUpperCase();
			
			// update account
			tempAccount.setName(theUpperCaseName);
		}
		
	}

	@Before("com.topekox.spring.aopdemo.aspect.TopekoxAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		logger.info("\n=====>>> Execution @Before advice on account()");
		
		// display the method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		logger.info("Method: " + methodSignature);
		
		// display method arguments
		
		// get args
		Object[] args = joinPoint.getArgs();
		
		for (Object tempObj : args) {
			logger.info(tempObj.toString());
			
			if (tempObj instanceof Account) {
				// downcast and print Account specific stuf
				Account account = (Account) tempObj;
				
				logger.info("Account name: " + account.getName());
				logger.info("Account level: " + account.getLevel());
			}
		}
		
	}
		
}
