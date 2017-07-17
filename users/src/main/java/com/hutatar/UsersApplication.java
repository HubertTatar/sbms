package com.hutatar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//https://fernandoabcampos.wordpress.com/
//http://www.dineshonjava.com/2017/01/microservices-with-spring-boot.html
//https://spring.io/blog/2015/07/14/microservices-with-spring
//https://github.com/cer/event-sourcing-examples
//http://localhost:8001/users/dev
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}
}
