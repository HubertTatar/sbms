package com.hutatar;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
//http://codecentric.github.io/spring-boot-admin/1.5.2/#_what_is_spring_boot_admin
//https://blog.codecentric.de/en/2016/04/event-driven-microservices-spring-cloud-stream/
//https://content.pivotal.io/blog/messaging-patterns-for-event-driven-microservices