package com.example.quartz;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: quartz
 * @Package com.example.quartz
 * @Description:
 * @date 2020/1/7 星期二 11:40
 */
public class TestCron {
    public static void main(String[] args)throws Exception {
        //任务
        JobDetail jobDetail=new JobDetail("a",MyJob.class);
        //触发器
        CronTrigger cronTrigger=new CronTrigger("b",null,"0/3 * 12 * * ?");
        //调度器工厂
        SchedulerFactory factory=new StdSchedulerFactory();
        //获得调度器
        Scheduler scheduler=factory.getScheduler();
        //把任务和触发器加入这个调度
        scheduler.scheduleJob(jobDetail,cronTrigger);
        //启动
        scheduler.start();
    }
}
