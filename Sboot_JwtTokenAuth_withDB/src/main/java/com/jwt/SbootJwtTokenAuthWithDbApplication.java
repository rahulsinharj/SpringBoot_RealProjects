package com.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootJwtTokenAuthWithDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootJwtTokenAuthWithDbApplication.class, args);
		
		System.out.println("JWT Auth with Database !");
	}

}
