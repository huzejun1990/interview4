package com.dream.interview4.service.impl;

import com.dream.interview4.service.CouponService;
import com.dream.interview4.service.CouponServiceV2;
import com.dream.interview4.utils.TaskBatchSendUtils;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : huzejun
 * @Date: 2024/8/29-3:19
 */
@Service
public class CouponServiceV2Impl implements CouponServiceV2 {

    //下发优惠券数量
    public static final Integer COUPON_NUMBER = 50;

    @Resource
    private ThreadPoolTaskExecutor threadPool;

    @SneakyThrows
    @Override
    public void batchTaskActionV2() {
        //1 模拟要下发的50条优惠券，上游系统给我们的下发优惠券源头
        List<String> coupons = getCoupons();

        long startTime = System.currentTimeMillis();

        //2 调用工具类批处理任务，这些优惠券coupons,放入线程池threadPool,做什么业务disposeTask下发
//        TaskBatchSendUtil.send();
        TaskBatchSendUtils.send(coupons,threadPool,TaskBatchSendUtils::disposeTaskV2);

        long endTime = System.currentTimeMillis();
        System.out.println("----costTime: "+(endTime - startTime) + " 毫秒");


    }

    private static List<String> getCoupons() {

        List<String> coupons = new ArrayList<>(COUPON_NUMBER);
        for (int i = 1; i < COUPON_NUMBER; i++) {
            coupons.add("优惠券--"+i);
        }
        return coupons;
    }
}
