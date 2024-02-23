package com.springboot.BankCard;

import com.springboot.BankCard.config.CardContactInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(value={CardContactInfo.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class BankCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankCardApplication.class, args);
	}

}
