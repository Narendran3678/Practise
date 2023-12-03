package com.springboot.SpringBootSecurity.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails userNaren = User.builder()
                .username("naren")
                .password("{noop}naren")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails userDivya = User.builder()
                .username("divya")
                .password("{noop}divya")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(userNaren,userDivya);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( configure -> { configure
                .requestMatchers(HttpMethod.GET,"/security/employees").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET,"/security/").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/security/employees/**").hasRole("MANAGER");
        })
        .httpBasic(Customizer.withDefaults())       // Use Http Basic Authentication
        .csrf(AbstractHttpConfigurer::disable) ;   // Disabling Cross Site Request Forgery

        return http.build();
    }
}
