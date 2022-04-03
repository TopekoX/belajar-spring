package com.topekox.spring.belajar;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.topekox.spring.belajar.log.MyLoggerConfigAnnotation;

@Configuration
//@ComponentScan("com.topekox.spring.belajar")
@PropertySource("classpath:mylogger.properties")
public class AplikasiConfig {

	@Bean
	public MyLoggerConfigAnnotation myLoggerConfig(@Value("${root.logger.level}") String rootLoggerLevel,
			@Value("${printed.logger.level}") String printedLoggerLevel) {
		
		MyLoggerConfigAnnotation loggerConfig = 
				new MyLoggerConfigAnnotation(rootLoggerLevel, printedLoggerLevel);
		
		return loggerConfig;		
	}
	
	// mendefinisikan minuman services
	@Bean
	public MinumanServices minumanServices() {
		return new CapTikusServices();
	}
	
	// mendefinisikan makanan dan inject depedency
	@Bean
	public Makanan nasiKuning() {
		return new NasiKuning(minumanServices());
	}
	
}
