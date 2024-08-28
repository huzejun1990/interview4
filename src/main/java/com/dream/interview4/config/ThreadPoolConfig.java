package com.dream.interview4.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author : huzejun
 * @Date: 2024/8/25-1:51
 */
@Configuration
public class ThreadPoolConfig {


    //线程池配置
    @Resource
    private ThreadPoolProperties threadPoolProperties;

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {

        ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();

        //核心线程池大小
        threadPool.setCorePoolSize(threadPoolProperties.getCorePoolSize());
        //最大创建的线程数
        threadPool.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());

        //等待队列最大长度
        threadPool.setQueueCapacity(threadPoolProperties.getQueueCapacity());
        //线程池维护线程所允许的空闲时间
        threadPool.setKeepAliveSeconds(threadPoolProperties.getKeepAliveSeconds());
        //异常方法内部线程名称
        threadPool.setThreadNamePrefix("spring默认线程池-");
        //络池对拒绝任务（无线程可用）的处理策略
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //任务都完成再关闭线程池
        threadPool.setWaitForTasksToCompleteOnShutdown(true);
        //任务初始化
        threadPool.initialize();

        return threadPool;


    }
}
