package com.example.employeeproject;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmployeeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeProjectApplication.class, args);
        System.out.println("Hello");
        log.info("\n Logger Activate:");

    }
}
