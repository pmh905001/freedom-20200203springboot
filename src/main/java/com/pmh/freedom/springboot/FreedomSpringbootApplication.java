package com.pmh.freedom.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.pmh.freedom.springboot.mapper")
public class FreedomSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreedomSpringbootApplication.class, args);
	}
	
	
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}

}
