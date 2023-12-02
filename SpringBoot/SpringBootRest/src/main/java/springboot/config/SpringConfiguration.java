package springboot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfiguration {
   /* @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails userNaren = User.builder()
                .username("naren")
                .password("naren")
                .roles("Employee","Manager")
                .build();
        UserDetails userDivya = User.builder()
                .username("divya")
                .password("divya")
                .roles("Employee")
                .build();

        return new InMemoryUserDetailsManager(userNaren,userDivya);
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.authorizeHttpRequests( condition -> {
            condition.requestMatchers(HttpMethod.GET,SpringConstants.API.GET_EMPLOYEES.apiUrl)
                        .hasRole(SpringConstants.ROLE.EMPLOYEE.toString())
                    .requestMatchers(HttpMethod.GET,SpringConstants.API.GET_ALL_EMPLOYEES.apiUrl)
                        .hasRole(SpringConstants.ROLE.EMPLOYEE.toString())
                    .requestMatchers(HttpMethod.GET,SpringConstants.API.POST_EMPLOYEES.apiUrl)
                        .hasRole(SpringConstants.ROLE.MANAGER.toString())
                    .requestMatchers(HttpMethod.GET,SpringConstants.API.UPDATE_EMPLOYEES.apiUrl)
                        .hasRole(SpringConstants.ROLE.MANAGER.toString())
                    .requestMatchers(HttpMethod.GET,SpringConstants.API.DELETE_EMPLOYEES.apiUrl)
                        .hasRole(SpringConstants.ROLE.ADMIN.toString());
        });
        // Use Http Basic Authentication
        security.httpBasic(Customizer.withDefaults());

        // Disabling Cross Site Request Forgery
        security.csrf(new Customizer<CsrfConfigurer<HttpSecurity>> () {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
                httpSecurityCsrfConfigurer.disable();
            }
        });
        return security.build();
    }*/
}
