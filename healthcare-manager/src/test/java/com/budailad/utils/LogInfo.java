package com.budailad.utils;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
