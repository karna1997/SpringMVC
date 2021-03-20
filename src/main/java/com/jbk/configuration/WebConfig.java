package com.jbk.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.jbk")
public class WebConfig {
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
		viewresolver.setPrefix("WEB-INF/page/");
		viewresolver.setSuffix(".jsp");
		return viewresolver;
	}

}
