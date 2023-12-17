package com.hello.helloprojectboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class HelloProjectBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloProjectBoardApplication.class, args);
	}

}
