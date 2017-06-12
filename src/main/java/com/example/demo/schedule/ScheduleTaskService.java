package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by kewuwei on 2017/6/9.
 */
@Service
public class ScheduleTaskService {



    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportTime(){
        System.out.println("每隔五秒执行一次"+dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 28 11 ? * *")
    private void fixDate() {
        System.out.println("指定时间 " + dateFormat.format(new Date()) + " 执行");
    }
}
