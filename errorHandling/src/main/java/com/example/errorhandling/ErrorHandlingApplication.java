package com.example.errorhandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ErrorHandlingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrorHandlingApplication.class, args);
    }

}
