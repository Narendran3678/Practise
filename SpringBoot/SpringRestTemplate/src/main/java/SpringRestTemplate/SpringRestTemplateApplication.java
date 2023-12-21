package SpringRestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "SpringRestTemplate.openfeignclient")
public class SpringRestTemplateApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringRestTemplateApplication.class, args);
	}
}
