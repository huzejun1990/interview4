package com.dream.interview4;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author : huzejun
 * @Date: 2024/7/29-3:54
 */
@SpringBootApplication
@MapperScan("com.dream.interview4.mapper")
public class Interview4Application {

    @Resource
    private ThreadPoolTaskExecutor threadPool;

    @PostConstruct
    public void getThreadPoolConfig() {
        System.out.println("**************测试threadPool getCorePoolSize: "+threadPool.getCorePoolSize());
        System.out.println("**************测试threadPool getMaxPoolSize: "+threadPool.getMaxPoolSize());
        System.out.println("**************测试threadPool getQueueCapacity: "+threadPool.getQueueCapacity());
        System.out.println("**************测试threadPool getKeepAliveSeconds: "+threadPool.getKeepAliveSeconds());
    }

    public static void main(String[] args) {
        SpringApplication.run(Interview4Application.class,args);
    }
}
