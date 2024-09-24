package com.dream.interview4.design.pattern.v1;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 22:48
 */
public class CocaHandler implements HandlerStrategy{
    @Override
    public void getCoca(String parameter) {
        System.out.println("我是可口可乐-only策略 "+parameter);
    }
}
