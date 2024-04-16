package com.example.demoredisson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoRedissonApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRedissonApplication.class, args);
    }

}
