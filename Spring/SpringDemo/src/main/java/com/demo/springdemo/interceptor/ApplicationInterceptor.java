package com.demo.springdemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApplicationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor Invoked");
        System.out.println(request.getParameter("locale") +" = "+request.getParameter("language"));
        System.out.println("Interceptor Closed");
        return true;
    }
}
