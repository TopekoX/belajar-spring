package com.topekox.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.topekox.spring.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	// create logger
	private static Logger logger =
			Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring containner
		TrafficFortuneService fortuneService = 
				context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		logger.info("\nMain Program: Around Demo App");
		
		logger.info("Calling getFortune");
		
		boolean tripWire = true;
		String data = fortuneService.getFortune(tripWire);
		
		logger.info("\nMy fortune is: " + data);
		logger.info("Finished");
		
		// close the context
		context.close();

	}

}
