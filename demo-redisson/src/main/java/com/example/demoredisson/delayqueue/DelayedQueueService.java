package com.example.demoredisson.delayqueue;

import java.util.concurrent.TimeUnit;

public interface DelayedQueueService {

    void addToDelayedQueue(String queueName, Object item, long delay, TimeUnit timeUnit);
}

