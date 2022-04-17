package com.topekox.spring.aopdemo.dao;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

//	@Before("execution(")
	public void addAccount() {
		System.out.println(getClass() + "\n===> DOING STUF: ADDING A MEMBERSHIP ACCOUNT");
	}
	
}
