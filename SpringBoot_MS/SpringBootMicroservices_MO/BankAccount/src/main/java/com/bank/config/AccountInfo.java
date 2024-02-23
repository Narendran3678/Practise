package com.bank.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.*;


//@ConfigurationProperties(prefix = "account")
public record AccountInfo(String message,String owner, Map<String,String> userInfo,List<String> AddressLine) {
}
