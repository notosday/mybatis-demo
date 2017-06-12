package com.example.demo.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by kewuwei on 2017/6/9.
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(EventConfig.class);

        DemoPublisher publisher = annotationConfigApplicationContext.getBean(DemoPublisher.class);

        publisher.publish("hello publish event");

        annotationConfigApplicationContext.close();
    }
}
