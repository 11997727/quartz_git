package com.example.quartz;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author 吴成卓
 * @version V1.0
 * @Project: quartz
 * @Package com.example.quartz
 * @Description:
 * @date 2020/1/7 星期二 09:55
 */
public class TestSimple {
    public static void main(String[] args)throws Exception {
        //工作实现类（你定义了一个实现Job接口的类，这个类仅仅表明该job需要完成什么类型的任务，
        // 除此之外，Quartz还需要知道该Job实例所包含的属性；这将由JobDetail类来完成。）
        JobDetail jobDetail=new JobDetail("a", MyJob.class);
        /**
         * SimpleTrigger的作用
         * 　　在一个指定时间段内执行一次作业任务或是在指定时间间隔内执行多次作业任务
         * SimpleTrigger总结:
         *
         * 　　1.重复次数可以是0，正整数或是SimpleTrigger.REPEAT_INDEFINITELY常量值。我们点击发现REPEAT_INDEFINITELY是-1，也就是-1表示无线次。
         *
         * 　　2.重复执行时间间隔必须为0或长整数。可以用小时，分钟，秒数的单位限制间隔
         *
         * 　　3.一旦指定了endTime参数，那么它会覆盖重复次数参数的效果。
         *
         *
         * CronTrigger的作用
         *  基于日历的作业调度器，而不是像SimpleTrigger那样精确指定间隔时间，比SimpleTrigger更常
         *
         *1.Cron表达式
         * 用于配置CronTrigger实例
         *
         * 是由7个子表达式组成的字符串，描述了时间表的详细信息
         *
         * 格式：[秒][分][小时][日][月][周][年]
         *
         * 书写规则:知道确定日期的写上，不知道的用*代替 　(年可以省略，只写前6个)
         *  Cron表达式小提示
         *
         * L和W可以一组合使用
         * 周字段英文字母不区分大小写即MON与mon相同
         * 利用工具，在线生成　　http://cron.qqe2.com/
         */
        //simple方式出发工作（触发名字：t1，触发方式：一直触发，触发间隔：3000毫秒）
        SimpleTrigger trigger=new SimpleTrigger("t1",SimpleTrigger.REPEAT_INDEFINITELY,3000);
        //开始触发时间（当前系统时间2000毫秒后开始）System.currentTimeMillis()获取当前系统时间戳
        trigger.setStartTime(new Date(System.currentTimeMillis()+2000));
        //事件结束时间（当前系统时间200000毫秒后结束工作）
        trigger.setEndTime(new Date(System.currentTimeMillis()+200000));
        //创建一个调度工厂
        SchedulerFactory factory=new StdSchedulerFactory();
        //创建一个调度器
        Scheduler s1=factory.getScheduler();
        //把触发和工作加入这个调度
        s1.scheduleJob(jobDetail,trigger);
        //调度准备就绪
        s1.start();
    }
}
