package com.topekox.spring.aopdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

import com.topekox.spring.belajar.log.MyLoggerConfigAnnotation;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.topekox.spring.aopdemo")
@PropertySource({ "classpath:mylogger.properties", "classpath:file.properties" })
public class DemoConfig {

	@Bean
	public MyLoggerConfigAnnotation myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
			@Value("${printed.logger.level}") String printedLoggerLevel) {

		MyLoggerConfigAnnotation loggerConfig = new MyLoggerConfigAnnotation(rootLoggerLevel, printedLoggerLevel);

		return loggerConfig;
	}

}
