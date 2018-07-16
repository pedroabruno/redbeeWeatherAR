package com.weather.arlocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.weather.arlocation.filter.CORSFilter;

@SpringBootApplication
public class ArlocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArlocationApplication.class, args);
		
	}
	
	@Bean
	public FilterRegistrationBean corsFilterRegistration(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean(new CORSFilter());
		registrationBean.setName("CORS Filter");
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(1);
		return registrationBean;
	}
}
