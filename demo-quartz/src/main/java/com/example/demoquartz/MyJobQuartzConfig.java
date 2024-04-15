package com.example.demoquartz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJobQuartzConfig {

    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger myJobTrigger(JobDetail job) {
        return TriggerBuilder.newTrigger()
                .forJob(job)
                .withIdentity("myJobTrigger")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();
    }
}

