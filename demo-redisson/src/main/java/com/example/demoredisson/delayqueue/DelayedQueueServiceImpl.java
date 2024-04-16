package com.example.demoredisson.delayqueue;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class DelayedQueueServiceImpl implements DelayedQueueService {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void addToDelayedQueue(String queueName, Object item, long delay, TimeUnit timeUnit) {
        RQueue<Object> queue = redissonClient.getQueue(queueName);
        RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(queue);
        delayedQueue.offer(item, delay, timeUnit);
        log.info("延迟消息增加成功[{}]", DateUtil.formatDateTime(DateUtil.date()));
    }
}

