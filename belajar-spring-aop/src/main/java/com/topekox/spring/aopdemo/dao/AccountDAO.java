package com.topekox.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.topekox.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " : doWork()");
		
		return false;
	}
	
}
