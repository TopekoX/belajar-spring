package com.github.topekox.belajar;

import com.mysql.cj.jdbc.MysqlDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("jdbc.properties")
@ComponentScan(basePackages = "com.github.topekox.belajar.dao")
public class KonfigurasiAplikasi {
    
    @Value("${database.url}")
    private String url;
    
    @Value("${database.user}")
    private String user;
    
    @Value("${database.password}")
    private String password;
    
    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        
        return dataSource;
    } 
    
    // supaya ${variabel} dalam jdbc.properties bisa terbaca
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
