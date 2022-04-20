package com.topekox.spring.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.topekox.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	// add new method findAccounts()
	public List<Account> findAccounts(boolean tripWare) {
		
		// for academic purpose... simulate a exception	
		if (tripWare) {
			throw new RuntimeException("No Cake for you.....");
		}
		
		List<Account> accounts = new ArrayList<>();
		Account account1 = new Account("Ucup", "Platinum");
		Account account2 = new Account("Ogi", "Silver");
		Account account3 = new Account("Adi", "Blue");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}
	
	public void addAccount(Account account, boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass() + " : doWork()");
		
		return false;
	}

	public String getName() {
		System.out.println(getClass() + " : in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : in setServiceCode()");
		this.serviceCode = serviceCode;
	}
		
}
