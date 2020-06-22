package com.example.LanzadorDcp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.LanzadorDcp")
public class LanzadorDcpApplication {

	public static void main(String[] args) {
		SpringApplication.run(LanzadorDcpApplication.class, args);
	}

}
