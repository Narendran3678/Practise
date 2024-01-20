package com.springboot.BankLoan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


//@ConfigurationProperties(prefix = "loan")
public record LoanInfo(String message, String owner, Map<String,String> userInfo, List<String> AddressLine) {
}
