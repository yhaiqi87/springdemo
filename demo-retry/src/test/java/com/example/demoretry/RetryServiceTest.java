package com.example.demoretry;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

class RetryServiceTest {

    @Test
    void readsome() {
        doSomething(1);
        doSomething(0);
    }

    @SneakyThrows
    private void doSomething(int i) {
        if (i == 0) {
            throw new Exception("111");
        }
        System.out.println(System.currentTimeMillis());
    }
}
