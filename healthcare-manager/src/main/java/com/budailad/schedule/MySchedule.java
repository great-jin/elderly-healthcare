package com.budailad.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MySchedule {

    Logger logger = LoggerFactory.getLogger(getClass());

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 定时任务，每10分钟打印一次时间
     */
    @Scheduled(fixedRate = 600000)
    public void reportCurrentTime() {
        logger.info("现在时间：" + dateFormat.format(new Date()));
    }
}
