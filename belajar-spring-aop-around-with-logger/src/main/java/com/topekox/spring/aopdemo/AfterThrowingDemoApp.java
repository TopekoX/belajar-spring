package com.topekox.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.topekox.spring.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring containner
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method find account
		List<Account> accounts = accountDAO.findAccounts(false);
		
		// display the account
		System.out.println("\n\nMain Program: After Returning Demo App");
		System.out.println("------");
		
		System.out.println(accounts);
		
		System.out.println("\n");
			
		// close the context
		context.close();

	}

}
