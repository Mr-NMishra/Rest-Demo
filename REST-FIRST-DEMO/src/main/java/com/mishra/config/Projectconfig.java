package com.mishra.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mishra")
public class Projectconfig {

@Bean
public ComboPooledDataSource dataSource() {
	ComboPooledDataSource dataSource= new ComboPooledDataSource();
	try {
		dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
	} catch (PropertyVetoException e) {
		// TODO Auto-generated catch block
		System.out.println("Datasource not connected--"+e);
		e.printStackTrace();
	}
	dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/RestDemo");
	dataSource.setUser("root");
	dataSource.setPassword("Password123#@!");
	return dataSource;
}
	
@Bean
public LocalSessionFactoryBean sessionFactory() {
	LocalSessionFactoryBean factoryBean= new LocalSessionFactoryBean();;
	factoryBean.setDataSource(dataSource());
	factoryBean.setPackagesToScan("com.mishra.entity");
	Properties hibernateProperties= new Properties();
	hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
	hibernateProperties.setProperty("hibernate.show_sql", "true");
	factoryBean.setHibernateProperties(hibernateProperties);
	return factoryBean;
}
}
