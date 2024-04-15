package com.example.demoquartz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DemoQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoQuartzApplication.class, args);
        log.info("=====================================");
        log.info("==============启动成功=================");
        log.info("=====================================");
    }

}
