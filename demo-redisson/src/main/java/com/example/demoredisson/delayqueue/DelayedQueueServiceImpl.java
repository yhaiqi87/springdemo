package com.example.demoredisson.delayqueue;

import org.redisson.api.RDelayedQueue;
import org.redisson.api.RQueue;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DelayedQueueServiceImpl implements DelayedQueueService {

    @Autowired
    private RedissonClient redissonClient;

    @Override
    public void addToDelayedQueue(String queueName, Object item, long delay, TimeUnit timeUnit) {
        RQueue<Object> queue = redissonClient.getQueue(queueName);
        RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(queue);
        delayedQueue.offer(item, delay, timeUnit);
    }
}

