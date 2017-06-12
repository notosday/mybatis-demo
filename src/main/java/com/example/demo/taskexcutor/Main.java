package com.example.demo.taskexcutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kewuwei on 2017/6/9.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExcutorConfig.class);

        AsyncTaskService bean = context.getBean(AsyncTaskService.class);

        for (int i =1 ;i <10 ;i++) {
            bean.excuteTask(i);
            bean.excuteTask2(i);
        }

        context.close();
    }
}
