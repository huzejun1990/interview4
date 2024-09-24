package com.dream.interview4.design.pattern.v2;


import org.springframework.stereotype.Component;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 23:27
 */
@Component
public class CocaHandlerV2 implements HandlerStrategyFactory {
    @Override
    public void getCoca(String parameter) {
        System.out.println("我是可口可乐-策略+工厂 "+parameter);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
                            // K        //V
        Factory.register("Coca",this);
    }
}
