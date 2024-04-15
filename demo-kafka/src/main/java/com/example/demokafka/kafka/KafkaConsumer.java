package com.example.demokafka.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/8/1 9:35
 */
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic", groupId = "myGroup")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}
