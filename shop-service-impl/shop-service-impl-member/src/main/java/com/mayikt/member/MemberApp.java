package com.mayikt.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.spring4all.swagger.EnableSwagger2Doc;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableApolloConfig
@EnableSwagger2Doc
public class MemberApp {
    public static void main(String[] args) {
		SpringApplication.run(MemberApp.class, args);
	}
}
