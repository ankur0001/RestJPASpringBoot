package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
public class BookServiceJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceJpaApplication.class, args);
	}

}
