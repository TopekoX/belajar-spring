package com.topekox.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.topekox.spring.aopdemo.dao.AccountDAO;
import com.topekox.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring containner
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership from spring containner
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class); 
		
		// call the bussines method
		Account account = new Account();
		accountDAO.addAccount(account, true);
		accountDAO.doWork();
		
		// call the accountdao setter/getter
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("silver");
		
		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();
		
		// call the membership method
		membershipDAO.addUcupMember();
		membershipDAO.goToSleep();
		
		// close the context
		context.close();

	}

}
