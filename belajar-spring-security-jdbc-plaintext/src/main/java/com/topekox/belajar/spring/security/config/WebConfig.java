package com.topekox.belajar.spring.security.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.topekox.belajar.spring.security")
@PropertySource("classpath:db.properties")
public class WebConfig implements WebMvcConfigurer {
	
	// set up variable to hold the properties
	@Autowired
	private Environment env;
	
	// set up Logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
	}
	
	// bean for security datasource
	@Bean
	public DataSource securityDataSource() {
		
		// create connection pool
		ComboPooledDataSource comboPooledDataSource =
				new ComboPooledDataSource();
		
		// set the jdbc driver class
		try {
			comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// log the connection
		logger.info(">>>>> jdbc.url = " + env.getProperty("jdbc.url"));
		logger.info(">>>>> jdbc.user = " + env.getProperty("jdbc.user"));
		
		// set the database pool properties
		comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		comboPooledDataSource.setInitialPoolSize(
				convertPropertyToInt("connection.pool.initialPoolSize"));
		comboPooledDataSource.setMinPoolSize(
				convertPropertyToInt("connection.pool.minPoolSize"));
		comboPooledDataSource.setMaxPoolSize(
				convertPropertyToInt("connection.pool.maxPoolSize"));
		comboPooledDataSource.setMaxIdleTime(
				convertPropertyToInt("connection.pool.maxIdleTime"));
		
		return comboPooledDataSource;
	}
	
	// need helper method read env convert to int
	private int convertPropertyToInt(String propName) {
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		
		return intPropVal;
	}

}
