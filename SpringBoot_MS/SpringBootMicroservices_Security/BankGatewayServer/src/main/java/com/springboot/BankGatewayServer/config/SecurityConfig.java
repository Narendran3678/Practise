package com.springboot.BankGatewayServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain springSecurityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity.authorizeExchange(exchanges ->
                exchanges.pathMatchers(HttpMethod.GET).permitAll()
                        .pathMatchers("/account/bank/**").authenticated()
                        .pathMatchers("/loan/bank/**").authenticated()
                        .pathMatchers("/card/bank/**").authenticated())
                        .oauth2ResourceServer(oAuth2ResourceServerSpec ->
                                oAuth2ResourceServerSpec.jwt(Customizer.withDefaults()));
        serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable);
        return serverHttpSecurity.build();
    }
}
