package com.springboot.BankEureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankEurekaApplication {
	//http://localhost:8070/eurekaserver/defualt  -> To Get Eureka Server Info
	//http://localhost:8060/ -> Eureka Server Info
	public static void main(String[] args) {
		SpringApplication.run(BankEurekaApplication.class, args);
	}
}
