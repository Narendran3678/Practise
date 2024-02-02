package com.springboot.BankGatewayServer;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import java.time.Duration;
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
										.retry(retry -> retry.setRetries(3)  // Number of retries should done before throwing error response
												.setMethods(HttpMethod.GET)  // Aply only for Error Response
												.setBackoff(Duration.ofMillis(100), Duration.ofMillis(1000),2,true) );
													// First Param is starting retry time, Second is limited time period for retry(100 to 100)
							})
							.uri("lb://LOAN-APPLICATION"); // MENTIONED UNDER EUREKA APPLICATION NAME
				})
				.route( (p) -> {
					return p.path("/card/**")
							.filters((filter) -> {
								return filter.rewritePath("/card/(?<segment>.*)","/${segment}")
										.addResponseHeader("X-Response-Time", LocalDateTime.now().toString());
							})
							.uri("lb://CARD-APPLICATION");
				})
				.build();
	}

	@Bean
	public Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
		System.out.println("Changing Default CircuitBreaker Fallback Timing");
		return factory -> factory.configureDefault(
				id -> new Resilience4JConfigBuilder(id).circuitBreakerConfig(
					CircuitBreakerConfig.ofDefaults()
				).timeLimiterConfig(
					TimeLimiterConfig.custom().timeoutDuration(
						Duration.ofSeconds(4)
					).build()
				).build()
		);
	}
}
