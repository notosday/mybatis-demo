package com.example.demo.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by kewuwei on 2017/6/9.
 */
@Configuration
@ComponentScan("com.example.demo.schedule")
@EnableScheduling
public class ScheduleConfig {
}
