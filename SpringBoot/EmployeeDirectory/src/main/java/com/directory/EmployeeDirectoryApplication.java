package com.directory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDirectoryApplication {
	//http://localhost:8081/dir/
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDirectoryApplication.class, args);
	}

}
