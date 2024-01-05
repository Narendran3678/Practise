package com.springboot.BankLoan.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "loan")
@Setter
@Getter
public class LoanContactInfo {
    private String message;
    private String owner;
    private Map<String,String> userInfo;
    private List<String> AddressLine;
}
