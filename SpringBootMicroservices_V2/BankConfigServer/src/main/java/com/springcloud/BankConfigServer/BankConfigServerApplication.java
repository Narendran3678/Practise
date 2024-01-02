package com.springcloud.BankConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BankConfigServerApplication {
	/*
	http://localhost:8070/account-application/default
	http://localhost:8070/account-application/uat
	http://localhost:8070/account-application/prod

	http://localhost:8070/card-application/default
	http://localhost:8070/card-application/uat
	http://localhost:8070/card-application/prod

	http://localhost:8070/loan-application/default
	http://localhost:8070/loan-application/uat
	http://localhost:8070/loan-application/prod

	http://localhost:8070/decrypt
	http://localhost:8070/encrypt

	http://localhost:8080/bank/actuator/refresh
	http://localhost:8090/bank/actuator/refresh
	http://localhost:9001/bank/actuator/refresh


	*/

	public static void main(String[] args) {
		SpringApplication.run(BankConfigServerApplication.class, args);
	}

}
