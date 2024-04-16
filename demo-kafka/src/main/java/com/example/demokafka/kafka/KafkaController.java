package com.example.demokafka.kafka;

import cn.hutool.core.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/send/{topic}")
    public void sendMessage(@PathVariable String topic) {
        kafkaProducer.sendMessage(topic, RandomUtil.randomString(10));
    }

}
