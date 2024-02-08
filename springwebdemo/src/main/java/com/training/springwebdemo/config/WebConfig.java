package com.training.springwebdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class WebConfig {

	@Bean
	public InternalResourceViewResolver initViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver(); 
		resolver.setPrefix("/");
		resolver.setSuffix(".html");
		return  resolver;
	}
	

}
