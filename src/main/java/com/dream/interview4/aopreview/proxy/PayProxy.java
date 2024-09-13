package com.dream.interview4.aopreview.proxy;

import com.dream.interview4.aopreview.PayService;

/**
 * @Author : huzejun
 * @Date: 2024/9/14-5:26
 */
public class PayProxy implements PayService {

    private PayService payService;

    public PayProxy(PayService payService)
    {
        this.payService = payService;
    }

    public void before() {
        System.out.println("-----before,打开微信");
    }


    @Override
    public void pay() {
        before();
        payService.pay();
        after();
    }

    private void after() {
        System.out.println("--------after,关闭微信");
    }

}
