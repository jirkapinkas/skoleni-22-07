package com.example.demoeshopweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class DemoEshopwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEshopwebApplication.class, args);
    }

}
