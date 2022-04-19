package com.topekox.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TopekoxAopExpressions {
	
	@Pointcut("execution(* com.topekox.spring.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {		
	}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.topekox.spring.aopdemo.dao.*.get*(..))")
	public void getter() {
		
	}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.topekox.spring.aopdemo.dao.*.set*(..))")
	public void setter() {
		
	}
	
	// create pointcut: include package.. exclude setter/getter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
		
	}
	
}
