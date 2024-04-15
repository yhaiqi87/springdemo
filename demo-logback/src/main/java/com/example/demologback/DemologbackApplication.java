package com.example.demologback;

import com.example.demologback.aaa.AaaService;
import com.example.demologback.bbb.BbbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class DemologbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemologbackApplication.class, args);
    }

}
