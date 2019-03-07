package com.mayikt.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableApolloConfig
public class OrderApp {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderApp.class, args);
	}

}
