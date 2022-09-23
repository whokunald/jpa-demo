package com.crossasyst.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
/*@ComponentScan(basePackages = {"com.crossasyst.jpademo.service","com.crossasyst.jpademo.controller"})*/
public class JpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Bean
	public RestTemplate postRestTemplate()
	{
		return  new RestTemplate();
	}

}

