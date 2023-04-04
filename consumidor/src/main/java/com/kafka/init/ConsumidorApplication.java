package com.kafka.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.kafka.controller", "com.kafka.service"})
public class ConsumidorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumidorApplication.class, args);
	}

}
