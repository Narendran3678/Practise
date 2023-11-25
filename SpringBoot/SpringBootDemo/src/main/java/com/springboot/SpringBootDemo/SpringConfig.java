package com.springboot.SpringBootDemo;
import com.springboot.SpringBootDemo.beans.ThirdPartyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {

    @Bean
    public ThirdPartyBean thirdPartyBean() {
        return new ThirdPartyBean();
    }
}
