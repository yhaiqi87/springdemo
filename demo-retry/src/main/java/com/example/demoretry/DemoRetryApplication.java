package com.example.demoretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;

@SpringBootApplication
@EnableRetry
public class DemoRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRetryApplication.class, args);
    }

}
