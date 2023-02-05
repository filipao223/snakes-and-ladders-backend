package com.example.snakesandladders;

import com.example.snakesandladders.config.impl.AppConfigurationImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfigurationImpl.class)
public class SnakesAndLaddersApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnakesAndLaddersApplication.class, args);
	}

}
