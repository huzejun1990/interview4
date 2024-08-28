package com.dream.interview4.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author : huzejun
 * @Date: 2024/8/25-1:46
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "thread.pool")
public class ThreadPoolProperties {

    /**
     * 核心线程池大小
     */
    private int corePoolSize;

    /**
     * 最大可创建的线程数
     */
    private int maxPoolSize;

    /**
     * 队列最大长度
     */
    private int queueCapacity;

    /**
     * 线程孙维护线程所允许的空闲时间
     */
    private int keepAliveSeconds;


}


