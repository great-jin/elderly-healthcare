package com.budailad.test.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ThreadAsyn {

    // 发送提醒短信 1
    @Async("taskExecutor")
    public void service1() throws InterruptedException {
        log.info("--------start-service1------------");
        Thread.sleep(5000); // 模拟耗时
        log.info("--------end-service1------------");
    }

    // 发送提醒短信 2
    @Async("taskExecutor")
    public void service2() throws InterruptedException {
        log.info("--------start-service2------------");
        Thread.sleep(2000); // 模拟耗时
        log.info("--------end-service2------------");
    }

}
