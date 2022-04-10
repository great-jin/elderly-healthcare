package com.budailad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

    private static final int corePoolSize = 10;         // 核心线程数（默认线程数）
    private static final int maxPoolSize = 100;         // 最大线程数
    private static final int keepAliveTime = 10;        // 允许线程空闲时间（单位：默认为秒）
    private static final int queueCapacity = 200;       // 缓冲队列数

    private static final String threadNamePrefix = "Async-Service-";    // 线程池名前缀

    /**
     * 初始化线程池配置
     *
     * bean的名称，默认为首字母小写的方法名
     */
    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveTime);
        executor.setThreadNamePrefix(threadNamePrefix);

        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }

}

