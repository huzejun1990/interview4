package com.dream.interview4.aopreview;

import com.dream.interview4.aopreview.proxy.PayProxy;

/**
 * @Author : huzejun
 * @Date: 2024/9/14-5:22
 */
public class ClientTest {

    private static void payNormalV1() {
        PayService payService = new PayServiceImpl();
        payService.pay();
    }

    private static void payProxyV2() {
        PayService payService = new PayProxy(new PayServiceImpl());
        payService.pay();
    }

    public static void main(String[] args) {
//        payNormalV1();
        payProxyV2();
    }
}
