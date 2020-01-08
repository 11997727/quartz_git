package com.example.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: quartz
 * @Package com.example.quartz
 * @Description:
 * @date 2020/1/7 星期二 09:53
 */
public class MyJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("这是要做的事情");
    }
}
