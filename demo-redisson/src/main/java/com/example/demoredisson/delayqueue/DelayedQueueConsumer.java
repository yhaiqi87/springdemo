package com.example.demoredisson.delayqueue;

import cn.hutool.core.date.DateUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2024/4/15 18:13
 */
@Slf4j
@Component
public class DelayedQueueConsumer {

    @Autowired
    private RedissonClient redissonClient;

    @SneakyThrows
    @Scheduled(fixedDelay = 1000) // 每秒执行一次
    public void consumeFromDelayedQueue() {
        log.info("开始消费消息[{}]", DateUtil.formatDateTime(DateUtil.date()));
        RQueue<Object> queue = redissonClient.getQueue(DelayedQueueConst.DELAYED_QUEUE_NAME);
        Object item = queue.poll();
        if (item != null) {
            // TimeUnit.SECONDS.sleep(1);
            log.info("Processing item from delayed queue: " + item);
        }
    }
}

