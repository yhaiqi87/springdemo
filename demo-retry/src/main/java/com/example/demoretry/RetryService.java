package com.example.demoretry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/8/19 15:33
 */
@Slf4j
@Service
public class RetryService {
    ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);
    // private int i = 0;

    @Retryable(value = {RuntimeException.class}, maxAttempts = 10, backoff = @Backoff(value = 500L))
    public String readsome(int random) throws IOException {
        int i = threadLocal.get();
        i++;
        threadLocal.set(i);
        log.info("random={},第{}次", random, i);
        if (i < random) {
            throw new RuntimeException("请求失败：" + i);
        }
        if (random == 8) {
            throw new IOException("test io ex");
        }
        // System.out.println("成功");
        return "成功";
    }


    @Recover
    public String readsomeRecover(Exception e) {
        log.info(e.getMessage());
        return "失败";
    }
}
