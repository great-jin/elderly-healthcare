package com.budailad.test.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ThreadAsyn {

    Logger logger = LoggerFactory.getLogger(getClass());

    // 发送提醒短信 1
    @Async("taskExecutor")
    public void service1() throws InterruptedException {
        logger.info("--------start-service1------------");
        Thread.sleep(5000); // 模拟耗时
        logger.info("--------end-service1------------");
    }

    // 发送提醒短信 2
    @Async("taskExecutor")
    public void service2() throws InterruptedException {
        logger.info("--------start-service2------------");
        Thread.sleep(2000); // 模拟耗时
        logger.info("--------end-service2------------");
    }

}
