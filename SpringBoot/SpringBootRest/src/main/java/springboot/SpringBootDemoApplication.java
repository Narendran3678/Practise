package springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("Command Line Runner Executed");
			}
		};
	}
}
