package Spring.Boot;

import Spring.Boot.dao.AccountDaoI;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootLoggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoggingApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AccountDaoI accountDaoI)
	{
		CommandLineRunner clr = new CommandLineRunner(){
			@Override
			public void run(String... args) throws Exception {
				System.out.println("CommandLineRunner Started");
				accountDaoI.addAccount();
			}
		};
		return clr;
	}
}
