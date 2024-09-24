package com.dream.interview4.design.pattern.v2;

import org.springframework.stereotype.Component;

/**
 * @Auther: huzejun
 * @Date: 2024/9/25 00:03
 */
@Component
public class WahahaHandlerV2 implements HandlerStrategyFactory {
    @Override
    public void getCoca(String parameter) {
        System.out.println("我是娃哈哈可乐-策略+工厂 "+parameter);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("Wahaha",this);
    }
}
