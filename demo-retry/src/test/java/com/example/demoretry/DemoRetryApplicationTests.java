package com.example.demoretry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoRetryApplicationTests {
    @Autowired
    RetryService retryService;

    @Test
    void contextLoads() throws Exception {
        // String readsome = retryService.readsome(RandomUtil.randomInt(0, 9));
        new Thread(() -> {
            try {
                System.out.println(retryService.readsome(8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                System.out.println(retryService.readsome(11));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
        Thread.sleep(20 * 1000);
    }

}
