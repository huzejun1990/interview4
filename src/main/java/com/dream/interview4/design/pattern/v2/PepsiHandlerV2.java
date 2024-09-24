package com.dream.interview4.design.pattern.v2;

import com.dream.interview4.design.pattern.v1.PepsiHandler;
import org.springframework.stereotype.Component;

/**
 * @Auther: huzejun
 * @Date: 2024/9/25 00:00
 */
@Component
public class PepsiHandlerV2 implements HandlerStrategyFactory {
    @Override
    public void getCoca(String parameter) {
        System.out.println("我是百事可乐-策略+工厂 "+parameter);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Factory.register("Pepsi",this);
    }
}
