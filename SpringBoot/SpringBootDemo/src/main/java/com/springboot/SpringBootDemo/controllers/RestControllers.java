package com.springboot.SpringBootDemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {
    @Value("${name}")
    private String name;

    @Value("${role}")
    private String role;
    @RequestMapping("/")
    public String indexMethod() {
        return "Hello World ["+name+"] Role ["+role+"]";
    }
}
