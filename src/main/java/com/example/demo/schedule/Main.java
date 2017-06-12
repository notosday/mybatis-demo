package com.example.demo.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kewuwei on 2017/6/9.
 */
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduleConfig.class);

    }
}
