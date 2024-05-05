package com.automotive;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        version = "1.0",
        description = "This is the open api for car rental",
        title = "Car Rental"))
public class AutomotiveApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutomotiveApplication.class, args);
    }

}
