package com.example.filebeat;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

//@SpringBootTest
class FilebeatApplicationTests {

    @Test
    void contextLoads() {
        String dateStr = "2023-03-01 01:07:22";
        System.out.println(DateUtil.formatBetween(new Date(), DateUtil.parse(dateStr,"yyyy-MM-dd HH:mm:ss")));
        System.out.println(DateUtil.formatBetween(new Date(), DateUtil.parse(dateStr,"yyyy-MM-dd HH:mm:ss"), BetweenFormater.Level.SECOND));
    }

}
