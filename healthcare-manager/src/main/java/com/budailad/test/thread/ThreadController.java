package com.budailad.test.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/test/thread")
public class ThreadController {

    @Autowired
    ThreadAsyn threadAsyn;

    /**
     * 线程异步调用方法
     */
    @GetMapping("/task1")
    public void task1() {
        try {
            threadAsyn.service1();
            threadAsyn.service2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
