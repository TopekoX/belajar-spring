package com.topekox.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.topekox.spring.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring containner
		TrafficFortuneService fortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Calling getFortune");
		
		String data = fortuneService.getFortune();
		
		System.out.println("\nMy fortune is: " + data);
		
		// close the context
		context.close();

	}

}
