package com.example.demo;

import com.example.demo.config.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {DemoApplication.class}, args);
	}
}
