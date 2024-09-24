package com.dream.interview4.design.pattern.v2;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 23:16
 */
public interface HandlerStrategyFactory extends InitializingBean {
    void getCoca(String parameter);
    // void afterPropertiesSet() throws Exception;
}

//V2 策略+工程+InitializingBean
