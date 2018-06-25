package com.mooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.mooc" })
public class SbootFreemarkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootFreemarkerApplication.class, args);
	}

}


