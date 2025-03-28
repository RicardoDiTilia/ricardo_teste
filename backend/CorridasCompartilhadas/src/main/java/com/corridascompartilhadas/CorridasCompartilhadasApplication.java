package com.corridascompartilhadas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.corridascompartilhadas")
public class CorridasCompartilhadasApplication {


    public static void main(String[] args) {
        SpringApplication.run(CorridasCompartilhadasApplication.class, args);
    }
}