package com.example.demoquartz;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MyJob implements Job {
    static AtomicInteger i = new AtomicInteger(0);

    @Override
    public void execute(JobExecutionContext context) {
        log.info("执行定时任务...  轮次：{} , 执行时间：{}", i.addAndGet(1), DateUtil.formatDateTime(new Date()));
    }
}

