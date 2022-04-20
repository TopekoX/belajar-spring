package com.topekox.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.topekox.spring.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	// create logger
	private static Logger logger =
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring containner
		TrafficFortuneService fortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("Calling getFortune");
		
		String data = fortuneService.getFortune();
		
		logger.info("\nMy fortune is: " + data);
		
		// close the context
		context.close();

	}

}
