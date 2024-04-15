package com.example.demologback;

import com.example.demologback.aaa.AaaService;
import com.example.demologback.bbb.BbbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Slf4j
@RestController
public class TestController {
    @Autowired
    AaaService aaaService;
    @Autowired
    BbbService bbbService;
    @Autowired
    CccService cccService;

    @GetMapping
    public String test1(){
        log.info("GetMapping开始执行定时任务------------------------------");
        aaaService.test();
        bbbService.test();
        cccService.test();
        // new ArrayList<String>(10)
        return "GetMapping ok";
    }

    @PostMapping
    public String test2(){
        log.info("PostMapping开始执行定时任务------------------------------");
        aaaService.test();
        bbbService.test();
        cccService.test();
        return "PostMapping ok";
    }

    @PutMapping
    public String test3(){
        log.info("PutMapping开始执行定时任务------------------------------");
        aaaService.test();
        bbbService.test();
        cccService.test();
        return "PutMapping ok";
    }

    @DeleteMapping
    public String test4(){
        log.info("DeleteMapping开始执行定时任务------------------------------");
        aaaService.test();
        bbbService.test();
        cccService.test();
        return "DeleteMapping ok";
    }

    @GetMapping("/test")
    public String test(){
        log.info("开始执行定时任务------------------------------");
        aaaService.test();
        bbbService.test();
        cccService.test();
        return "ok";
    }
}
