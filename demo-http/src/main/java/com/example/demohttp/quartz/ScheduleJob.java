package com.example.demohttp.quartz;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Map;

@Component
@Data
@ConfigurationProperties
public class ScheduleJob implements Serializable {

    public static final String STATUS_RUNNING = "1";
    public static final String STATUS_NOT_RUNNING = "0";
    /**
     * 任务名称
     */
    private String jobName;
    /**
     * 任务分组
     */
    private String jobGroup;
    /**
     * 任务状态 是否启动任务
     */
    private String jobStatus;
    /**
     * cron表达式
     */
    private String cronExpression;
    /**
     * spring bean
     */
    private String jobClass;
    /**
     * 任务调用的方法名
     */
    private String methodName;

    /**
     * 任务调用的方法传入的参数,统一使用String
     */
    private Map<String,String> parameters;
    /**
     * 任务是否有状态
     */
    private boolean isConcurrent;
}
