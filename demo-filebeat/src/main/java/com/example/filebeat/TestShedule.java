package com.example.filebeat;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class TestShedule {

    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {
        log.info(DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "----" + RandomUtil.randomString(12));
    }
}
