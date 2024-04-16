package com.example.demoredisson.delayqueue;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class DelayedQueueController {

    @Autowired
    private DelayedQueueService delayedQueueService;

    @PostMapping("/add")
    public String addToDelayedQueue(@RequestBody DelayQueueParam param) {
        log.info("添加延迟消息：{}", JSONUtil.toJsonStr(param));
        delayedQueueService.addToDelayedQueue(DelayedQueueConst.DELAYED_QUEUE_NAME, param.getItem(), param.getDelay(), TimeUnit.SECONDS);
        return "Item added to delayed queue successfully";
    }
}
