package com.example.demo.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by kewuwei on 2017/6/9.
 */
@Component
public class DemoPublisher {
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this,msg));

        applicationContext.publishEvent(new DemoEvent(this,msg+" 2"));
    }
}
