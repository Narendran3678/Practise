package com.springboot.SpringBootDemo.beans;

import com.springboot.SpringBootDemo.beaninterface.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("CricketObj")
@Primary
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Cricket Coach Initialized");
    }
    @Override
    public String dailyWorkout() {
        return "Train Cricket";
    }
}