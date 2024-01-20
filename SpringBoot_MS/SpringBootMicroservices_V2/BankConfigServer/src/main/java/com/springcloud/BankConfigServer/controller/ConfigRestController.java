package com.springcloud.BankConfigServer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigRestController {
    @GetMapping("/")
    public Map<String,String> indexMethod() {
        Map<String,String> info = new HashMap<>();
        info.put("1","http://localhost:8070/actuator/health");
        info.put("2","http://localhost:8070/actuator/health/liveness");
        info.put("3","http://localhost:8070/actuator/health/readiness");
        info.put("4","http://localhost:8070/account-application/default");
        info.put("5","http://localhost:8070/account-application/uat");
        info.put("6","http://localhost:8070/account-application/prod");
        info.put("7","http://localhost:8070/card-application/default");
        info.put("8","http://localhost:8070/card-application/uat");
        info.put("9","http://localhost:8070/card-application/prod");
        info.put("10","http://localhost:8070/loan-application/default");
        info.put("11","http://localhost:8070/loan-application/uat");
        info.put("12","http://localhost:8070/loan-application/prod");
        info.put("13","http://localhost:8070/decrypt");
        info.put("14","http://localhost:8070/encrypt");
        info.put("15","http://localhost:8080/bank/actuator/refresh");
        info.put("16","http://localhost:8090/bank/actuator/refresh");
        info.put("17","http://localhost:9001/bank/actuator/refresh");
        return info;
    }
}
