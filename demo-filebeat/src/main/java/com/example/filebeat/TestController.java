package com.example.filebeat;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 描述：
 * 作者：yhaiq
 * 时间：2023/1/12 16:53
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        String s = DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "----" + RandomUtil.randomString(5);
        log.info("请求结果：{}", s);
        return s;
    }
}
