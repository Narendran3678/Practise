package com.springboot.SpringBootDemo.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeClass {
    public PrototypeClass() {
        System.out.println("Prototype Class Instantiated");
    }
}
