package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TradeAssignment {

	public static void main(String[] args) {
		SpringApplication.run(TradeAssignment.class, args);
	}

}
