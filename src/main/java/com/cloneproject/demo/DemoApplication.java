package com.cloneproject.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@MapperScan("com.cloneproject.demo")
@SpringBootApplication
@EnableJpaRepositories
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}

