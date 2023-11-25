package com.springboot.SpringBootDemo.beans;

import com.springboot.SpringBootDemo.beaninterface.Coach;
import org.springframework.stereotype.Component;

@Component("BaseBallObj")
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("Baseball Coach Initialized");
    }
    @Override
    public String dailyWorkout() {
        return "Train BaseBall";
    }
}
