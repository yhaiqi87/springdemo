package com.example.demokafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/8/1 9:35
 */
@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "myTopic")
    public void myTopic(String message) {
        log.info("myTopic Received Message: " + message);
    }

    @KafkaListener(topics = "myApp")
    public void myApp(String message) {
        log.info("myApp Received Message: " + message);
    }

    @KafkaListener(topics = "myWeb")
    public void myWeb(String message) {
        log.info("myWeb Received Message: " + message);
    }

    @KafkaListener(topics = "myTest")
    public void myTest(String message) {
        log.info("myTest Received Message: " + message);
    }
}
