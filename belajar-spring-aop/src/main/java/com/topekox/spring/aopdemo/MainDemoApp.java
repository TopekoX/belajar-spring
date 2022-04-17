package com.topekox.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.topekox.spring.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring containner
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call the bussines method
		accountDAO.addAccount();
		
		// do it again
		System.out.println("\nlets call it again\n");
		
		// call the bussines method aggain
		accountDAO.addAccount();
		
		// close the context
		context.close();

	}

}
