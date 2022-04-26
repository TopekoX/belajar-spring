package com.topekox.spring.rest.crud.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.topekox.spring.rest.crud")
@PropertySource({"classpath:config.properties"})
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource dataSource() {
		
		// connection pool
		ComboPooledDataSource pooledDataSource = new ComboPooledDataSource();
		
		try {
			pooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		// log url and user
		logger.info(">>> JDBC URL : " + env.getProperty("jdbc.url"));
		logger.info(">>> JDBC User : " + env.getProperty("jdbc.user"));
		
		// set database pool properties
		pooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		pooledDataSource.setUser(env.getProperty("jdbc.user"));
		pooledDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool properties
		pooledDataSource.setInitialPoolSize(getIntProperties("connection.pool.initialPoolSize"));
		pooledDataSource.setMinPoolSize(getIntProperties("connection.pool.minPoolSize"));
		pooledDataSource.setMaxPoolSize(getIntProperties("connection.pool.maxPoolSize"));
		pooledDataSource.setMaxIdleTime(getIntProperties("connection.pool.maxIdleTime"));
		
		return pooledDataSource;
	}

	// method convert properties value to int
	private int getIntProperties(String property) {
		String value = env.getProperty(property);
		
		int intPropValue = Integer.parseInt(value);
		
		return intPropValue;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		factoryBean.setHibernateProperties(getHibernateProperties());
		
		return factoryBean;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		
		return properties;
	}
	
	// Hibernate Transaction Manager
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		
		return txManager;
	}

}
