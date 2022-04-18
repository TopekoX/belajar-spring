package com.topekox.spring.aopdemo.dao;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addUcupMember() {
		System.out.println(getClass() + " DOING STUF: ADDING A MEMBERSHIP ACCOUNT");
		
		return true;
	}
	
	
	
}
