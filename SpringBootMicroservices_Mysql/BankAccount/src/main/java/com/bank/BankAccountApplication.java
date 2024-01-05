package com.bank;
import com.bank.config.AccountContactInfo;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountContactInfo.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Account Microservices",
				description = "Spring Boot Microservices",
				version = "v1",
				contact = @Contact(
						name="Narendran",
						email = "narendran3678@gmail.com",
						url = "http://localhost:8081/bank/api"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://localhost:8081/bank/api"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Swagger UI Docs",
				url = "https://www.eazybytes.com/swagger-ui.html"
		)
)
public class BankAccountApplication {
	public static void main(String[] args) {
		SpringApplication.run(BankAccountApplication.class, args);
	}
}
