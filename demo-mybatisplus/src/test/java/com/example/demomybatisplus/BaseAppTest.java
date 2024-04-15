package com.example.demomybatisplus;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BaseAppTest {
    long start;

    @BeforeEach
    void setUp() {
        log.info("=====================开始");
        start = System.currentTimeMillis();
    }

    @AfterEach
    void tearDown() {
        log.info("=====================结束，耗时{}ms", System.currentTimeMillis() - start);
    }

}
