package com.example.demoredisson.delayqueue;

import lombok.Data;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2024/4/16 8:58
 */
@Data
public class DelayQueueParam {
    String queueName;
    String item;
    long delay;
}
