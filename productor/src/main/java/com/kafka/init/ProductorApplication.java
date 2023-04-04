package com.kafka.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kafka.controller", "com.kafka.service"})
public class ProductorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductorApplication.class, args);
	}

}
