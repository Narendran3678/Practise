package com.springboot.BankGatewayServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class BankGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankGatewayServerApplication.class, args);
	}

	@Bean
	public RouteLocator bankRouteLocatorConfigurator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route( (p) -> {
					return p.path("/account/**")
							.filters((filter) -> {
								return filter.rewritePath("/account/(?<segment>.*)","/${segment}")
										.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
										.circuitBreaker( config -> config.setName("account-circuit-breaker")
												.setFallbackUri("forward:/contactsupport"));
							})
							.uri("lb://ACCOUNT-APPLICATION");
				})
				.route( (p) -> {
					return p.path("/loan/**") //Customer name to be used
							.filters((filter) -> {
								return filter.rewritePath("/loan/(?<segment>.*)","/${segment}") // First Parameter will be replace to second one
										.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
										.circuitBreaker( config -> config.setName("loan-circuit-breaker")
												.setFallbackUri("forward:/contactsupport"));
							})
							.uri("lb://LOAN-APPLICATION"); // MENTIONED UNDER EUREKA APPLICATION NAME
				})
				.route( (p) -> {
					return p.path("/card/**")
							.filters((filter) -> {
								return filter.rewritePath("/card/(?<segment>.*)","/${segment}")
										.addResponseHeader("X-Response-Time", LocalDateTime.now().toString())
										.circuitBreaker( config -> config.setName("card-circuit-breaker")
												.setFallbackUri("forward:/contactsupport"));
							})
							.uri("lb://CARD-APPLICATION");
				})
				.build();

	}
}
