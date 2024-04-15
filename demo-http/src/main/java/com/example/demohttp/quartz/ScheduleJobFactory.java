package com.example.demohttp.quartz;

import cn.hutool.json.JSONUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class ScheduleJobFactory {

    public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private QuartzConfig quartzConfig;

    /**
     * 初始化任务
     *
     * @param job
     */
    public void initJob(ScheduleJob job) throws Exception {
        if (job == null) {
            return;
        }
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());

        if (!ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            logger.info("删除任务{}", job.getJobName());
            this.deleteJob(scheduler, triggerKey);
        } else {
            logger.info(scheduler + "添加任务:{}", JSONUtil.toJsonStr(job));
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            addJob(scheduler, triggerKey, job);
        }

    }

    /**
     * 增加定时任务job
     *
     * @param scheduler  调度器
     * @param triggerKey 触发器key
     * @param job        任务
     * @throws Exception
     */
    private void addJob(Scheduler scheduler, TriggerKey triggerKey, ScheduleJob job) throws Exception {
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if (null == trigger) {
            // 不存在,创建一个
            setJobExistTrigger(scheduler, trigger, triggerKey, job);
        } else {
            setJobNoExistTrigger(scheduler, trigger, triggerKey, job);
        }
    }

    /**
     * 如果触发器key不存在,设置job
     *
     * @param scheduler  调度器
     * @param trigger    触发器
     * @param triggerKey 触发器key
     * @param job        任务
     * @throws Exception
     */
    private void setJobNoExistTrigger(Scheduler scheduler, CronTrigger trigger, TriggerKey triggerKey, ScheduleJob job)
            throws Exception {
        // Trigger已存在，那么更新相应的定时设置
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
        // 按新的cronExpression表达式重新构建trigger
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        // 按新的trigger重新设置job执行
        scheduler.rescheduleJob(triggerKey, trigger);
    }

    /**
     * 如果触发器key存在,设置job
     *
     * @param scheduler  调度器
     * @param trigger    触发器
     * @param triggerKey 触发器key
     * @param job        任务
     * @throws Exception
     */
    private void setJobExistTrigger(Scheduler scheduler, CronTrigger trigger, TriggerKey triggerKey, ScheduleJob job)
            throws Exception {
        Class clazz = job.isConcurrent() ? QuartzJobFactoryAllowConcurrentExecution.class
                : QuartzJobFactoryDisallowConcurrentExecution.class;

        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();
        jobDetail.getJobDataMap().put("scheduleJob", job);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());

        trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                .withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, trigger);
    }

    /**
     * 删除job
     *
     * @param scheduler
     * @param triggerKey
     * @throws Exception
     */
    private void deleteJob(Scheduler scheduler, TriggerKey triggerKey) throws Exception {
        if (null != triggerKey) {
            scheduler.unscheduleJob(triggerKey);
        }
    }

    /**
     * 初始化job
     *
     * @throws Exception
     */
    @PostConstruct
    public void init() {
        // 这里获取任务信息数据
        List<ScheduleJob> jobList = quartzConfig.getJobs();
        try {
            logger.info("任务初始化开始....");
            for (ScheduleJob job : jobList) {
                initJob(job);
            }
        } catch (Exception e) {
            logger.error("任务初始化异常", e);
        }

    }
}
