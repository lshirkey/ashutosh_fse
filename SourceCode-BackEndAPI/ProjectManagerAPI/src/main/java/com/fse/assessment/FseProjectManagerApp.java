package com.fse.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Tells SpringBoot that this is the starting point of
						// our Spring Boot Application
public class FseProjectManagerApp {

	public static void main(String[] args) {
		SpringApplication.run(FseProjectManagerApp.class, args);
		// This static method
		// Sets the default configurations
		// Starts the spring application context
		// Performs class path scan
		// Starts the embedded TOMCAT server

	}
	
	


}


