package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.*"})
public class ResourceManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ResourceManagementApplication.class, args);
	}
}

