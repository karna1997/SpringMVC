package com.jbk.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import com.jbk.pojo.User;

@Configuration
public class HibernateConfig {
	@Autowired
	ApplicationContext context;
	
	@Bean
	public LocalSessionFactoryBean getFactoryBean(){
		LocalSessionFactoryBean factorybean= new LocalSessionFactoryBean();
		factorybean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factorybean.setAnnotatedClasses(User.class);
		return factorybean;
	}
	

}
