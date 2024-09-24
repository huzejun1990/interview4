package com.dream.interview4.design.pattern.v1;

import org.springframework.stereotype.Component;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 22:51
 */
@Component
public class WahahaHandler implements HandlerStrategy {
    @Override
    public void getCoca(String parameter) {
        System.out.println("我是娃哈哈可乐-only策略 "+parameter);
    }
}
