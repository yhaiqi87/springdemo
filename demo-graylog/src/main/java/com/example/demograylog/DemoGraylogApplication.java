package com.example.demograylog;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class DemoGraylogApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoGraylogApplication.class, args);
    }

    @Scheduled(cron = "0/2 * * * * ?")
    public void te1() {
        log.info(DateUtil.formatDateTime(new Date()));
    }

}
