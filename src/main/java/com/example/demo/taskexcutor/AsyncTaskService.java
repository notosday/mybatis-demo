package com.example.demo.taskexcutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by kewuwei on 2017/6/9.
 */
@Service
public class AsyncTaskService {

    @Async
    public void excuteTask(int i) {
        System.out.println("执行异步任务: "+i);
    }

    @Async
    public void excuteTask2(int i) {
        System.out.println("执行异步任务+1 :"+ i +1);
    }
}
