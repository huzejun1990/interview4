package com.dream.interview4.design.pattern.v1;

import org.springframework.stereotype.Component;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 22:50
 */
@Component
public class PepsiHandler implements  HandlerStrategy{
    @Override
    public void getCoca(String parameter) {
        System.out.println("我是百事可乐-only策略 "+parameter);
    }
}
