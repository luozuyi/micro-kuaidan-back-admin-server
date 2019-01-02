package com.kuaidan.config;

import com.kuaidan.quartz.ConfirmOrderQuartzCore;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * author luo
 *
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail ConfirmOrderQuartzCoreDetail(){
        return JobBuilder.newJob(ConfirmOrderQuartzCore.class).withIdentity("ConfirmOrderQuartzCore").storeDurably().build();
    }

    @Bean
    public Trigger userContinuePublishRecordQuartzCoreTrigger(){
        //每天凌晨1点执行一次
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0 0 1 * * ?");
        return TriggerBuilder.newTrigger().forJob(ConfirmOrderQuartzCoreDetail())
                .withIdentity("ConfirmOrderQuartzCore")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
