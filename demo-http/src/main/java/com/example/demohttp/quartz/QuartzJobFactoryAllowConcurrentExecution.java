package com.example.demohttp.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/** 允许并行执行 */
public class QuartzJobFactoryAllowConcurrentExecution implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        TaskUtils.invokeMethod(scheduleJob);
    }
}
