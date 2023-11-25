package com.springboot.SpringBootDemo.beans;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonClass {
    public SingletonClass() {
        System.out.println("Singleton Class Instantiated");
    }
}
