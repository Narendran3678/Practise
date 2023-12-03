package springboot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

@Configuration
public class SpringConfiguration {


    //JDBC Authentication with predefined Table
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        //Table Users,Authorities need to same as exact with username,password,enabled as field in users and username,authority in authorities table
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT FIRSTNAME,PASSWORD,ACTIVE_FLAG FROM EMPLOYEE WHERE FIRSTNAME=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT DISTINCT E.FIRSTNAME,R.ROLENAME FROM EMPLOYEE E,EMPLOYEE_ROLE ER,ROLES R WHERE E.ID=ER.EMPLOYEE_ID AND R.ROLE_ID=ER.ROLE_ID AND E.FIRSTNAME=?");

        return jdbcUserDetailsManager;
    }

    /*
    //Declarative Authentication
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
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests( condition -> { condition
                        .requestMatchers(HttpMethod.GET,"/rest/employees").hasRole("MANAGER");
            /*.requestMatchers(HttpMethod.GET,SpringConstants.API.GET_ALL_EMPLOYEES.apiUrl)
                .hasRole(SpringConstants.ROLE.EMPLOYEE.toString())
            .requestMatchers(HttpMethod.GET,SpringConstants.API.GET_EMPLOYEES.apiUrl)
                .hasRole(SpringConstants.ROLE.EMPLOYEE.toString())

            .requestMatchers(HttpMethod.GET,SpringConstants.API.POST_EMPLOYEES.apiUrl)
                .hasRole(SpringConstants.ROLE.MANAGER.toString())

            .requestMatchers(HttpMethod.GET,SpringConstants.API.UPDATE_EMPLOYEES.apiUrl)
                .hasRole(SpringConstants.ROLE.MANAGER.toString())

            .requestMatchers(HttpMethod.GET,SpringConstants.API.DELETE_EMPLOYEES.apiUrl)
                .hasRole(SpringConstants.ROLE.ADMIN.toString());
        }).httpBasic(Customizer.withDefaults())  // Use Http Basic Authentication
                .csrf(AbstractHttpConfigurer::disable); // Disabling CSRF
        return httpSecurity.build();
    }*/
}
