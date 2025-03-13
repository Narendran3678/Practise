package com.demo.springdemo.config;
import com.demo.springdemo.interceptor.ApplicationInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.*;

import java.time.Duration;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/public", "classpath:/static/")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(365)));
    }

    /*
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix("/marketing", HandlerTypePredicate.forAnnotation(Controller.class));
    }
    */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApplicationInterceptor());
    }
}
