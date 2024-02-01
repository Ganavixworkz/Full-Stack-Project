package com.xworkz.rto.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz")
@Slf4j
public class RtoConfiguration {
public RtoConfiguration() {
log.info("RtoConfiguration");
}
@Bean
public ViewResolver viewResolver() {
	log.info("view resolver bean created");
	InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	resolver.setPrefix("/");
	resolver.setSuffix(".jsp");
	return resolver;
	
}
@Bean
public LocalContainerEntityManagerFactoryBean lcefb() {
	log.info("LocalContainerEntityManagerFactoryBean created");
	LocalContainerEntityManagerFactoryBean bean=new LocalContainerEntityManagerFactoryBean();
	return bean;
}
}
