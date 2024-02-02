package com.bank.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "account")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AccountContactInfo {
    private String message;
    private String owner;
    private Map<String,String> userInfo;
    private List<String> AddressLine;
}
