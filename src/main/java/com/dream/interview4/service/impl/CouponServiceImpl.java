package com.dream.interview4.service.impl;

import com.dream.interview4.service.CouponService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author : huzejun
 * @Date: 2024/8/28-23:15
 */
@Service
public class CouponServiceImpl implements CouponService {

    //下发优惠券数量
    public static final Integer COUPON_NUMBER = 50;

    @Resource
    private ThreadPoolTaskExecutor threadPool;

    /**
     * 下发50条优惠券
     */
    @Override
    public void batchTaskAction() {

        //1 模拟要下发的50条优惠券，上游系统给我们下发优惠券源头
        List<String> coupons = new ArrayList<>(COUPON_NUMBER);
        for (int i = 1; i < COUPON_NUMBER; i++) {
            coupons.add("优惠券--"+i);
        }

        //2 创建CountDownLatch,构造器参数为任务数量
        CountDownLatch countDownLatch = new CountDownLatch(coupons.size());

        long startTime = System.currentTimeMillis();
        try {
            //3 优惠券集合逐条发送线程
            for (String coupon : coupons) {
                threadPool.execute(() -> {
                    try {
                        //4.交给线程池处理的下发业务逻辑，可以提出成一个方法
                        System.out.println(String.format("【%s】发送成功",coupon));
                    } finally {
                    // 5 发送一个少一个任务，计数减少一个
                        countDownLatch.countDown();
                    }
                });
            }
            // 6 阻塞当前发送完毕后，方法才能继续向下走
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-------------任务处理完毕costTime: "+(endTime - startTime)+ " 毫秒");
    }

}
