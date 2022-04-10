package com.budailad.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogInfo {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    void LoggerDemo() {
        //日志级别 由低到高
        logger.trace("trace 级别日志");
        logger.debug("debug 级别日志");
        logger.info("info 级别日志");
        logger.warn("warn 级别日志");
        logger.error("error 级别日志");
    }

    /**
     * 使用 log 只需在类上添加 @Slf4j 注解
     */
    @Test
    void Slf4jDemo() {
        //日志级别 由低到高
        log.trace("trace 级别日志");
        log.debug("debug 级别日志");
        log.info("info 级别日志");
        log.warn("warn 级别日志");
        log.error("error 级别日志");
    }

}
