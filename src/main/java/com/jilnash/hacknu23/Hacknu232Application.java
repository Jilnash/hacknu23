package com.jilnash.hacknu23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Hacknu232Application {

    public static void main(String[] args) {
        SpringApplication.run(Hacknu232Application.class, args);
    }

}
