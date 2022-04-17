package com.topekox.spring.aopdemo.dao;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

//	@Before("execution(")
	public void addUcupMember() {
		System.out.println(getClass() + " DOING STUF: ADDING A MEMBERSHIP ACCOUNT");
	}
	
}
