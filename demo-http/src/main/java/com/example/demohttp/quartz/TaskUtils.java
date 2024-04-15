package com.example.demohttp.quartz;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.Map;

public class TaskUtils {
    private static final Logger logger = LoggerFactory.getLogger(TaskUtils.class);

    /**
     * 通过反射调用scheduleJob中定义的方法
     *
     * @param scheduleJob
     */
    public static void invokeMethod(ScheduleJob scheduleJob) {
        Object object = null;
        Class clazz;
        if (StrUtil.isNotBlank(scheduleJob.getJobClass())) {
            object = SpringUtil.getBean(scheduleJob.getJobClass());
        }
        if (object == null) {
            logger.error("任务名称 = [" + scheduleJob.getJobName() + "]未启动成功，请检查是否配置正确！！！");
            return;
        }
        clazz = object.getClass();
        Method method = null;
        try {
            if (scheduleJob.getParameters() == null) {
                method = clazz.getDeclaredMethod(scheduleJob.getMethodName());
                method.invoke(object);
            } else {
                method = clazz.getDeclaredMethod(scheduleJob.getMethodName(), Map.class);
                method.invoke(object, scheduleJob.getParameters());
            }
        } catch (Exception e) {
            logger.error("job反射执行方法异常", e);
        }
    }
}
