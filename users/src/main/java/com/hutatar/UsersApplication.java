package com.hutatar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//https://fernandoabcampos.wordpress.com/
//http://www.dineshonjava.com/2017/01/microservices-with-spring-boot.html
//https://spring.io/blog/2015/07/14/microservices-with-spring
@SpringBootApplication
public class UsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
		Test t = new Test();
		System.out.println("####################################"+t.test);
	}
}
