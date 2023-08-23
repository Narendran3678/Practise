package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "components")
@PropertySource("classpath:spring.properties")
public class SpringAppConfig {
	
	/*
	@Bean(name="heart")
	public Heart getHeart()
	{
		return new HumanHeart();
	}
	*/
}
