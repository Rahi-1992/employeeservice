package com.virtusaemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.virtusaemployee")

public class EmployeeserviceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EmployeeserviceApplication.class, args);
	}

}
