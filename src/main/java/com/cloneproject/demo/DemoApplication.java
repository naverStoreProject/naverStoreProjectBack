package com.cloneproject.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@MapperScan(basePackages = {
		"com.cloneproject.demo.orderGroup.repository",
		"com.cloneproject.demo.orderItem.repository",
		"com.cloneproject.demo.product.repository.mapper"
})
@SpringBootApplication
@EnableJpaRepositories(basePackages = {
		"com.cloneproject.demo.member.repository",
		"com.cloneproject.demo.mainBanner"
})
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}