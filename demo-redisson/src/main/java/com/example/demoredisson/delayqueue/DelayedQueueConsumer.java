package com.example.demoredisson.delayqueue;

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
@Component
public class DelayedQueueConsumer {

    @Autowired
    private RedissonClient redissonClient;

    @Scheduled(fixedDelay = 1000) // 每秒执行一次
    public void consumeFromDelayedQueue() {
        RQueue<Object> queue = redissonClient.getQueue("your_delayed_queue_name");
        while (true) {
            Object item = queue.poll();
            if (item == null) {
                break; // 队列为空时退出循环
            }
            // 处理队列中的任务
            System.out.println("Processing item from delayed queue: " + item.toString());
        }
    }
}

