package com.demo.springdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@Component
public class AppFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        System.out.println("Application Filter Invoked");
        Map<String, String[]> extraParams = new TreeMap<String, String[]>();
        //extraParams.put("locale",new String[] {"es_ES"});
        HttpServletRequest wrappedRequest = new CustomHttpServletRequestWrapper((HttpServletRequest) servletRequest, extraParams);
        chain.doFilter(wrappedRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
