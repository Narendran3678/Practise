package com.springboot.BankCard.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


//@ConfigurationProperties(prefix = "card")
public record CardInfo(String message, String owner, Map<String,String> userInfo, List<String> AddressLine) {
}
