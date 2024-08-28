package com.dream.interview4.utils;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/**
 * @Author : huzejun
 * @Date: 2024/8/29-3:37
 */
public class TaskBatchSendUtils {

    public static <T> void send(List<T> taskList, Executor threadPool, Consumer<? super T> consumer) throws InterruptedException {

        if (taskList == null || taskList.size() == 0) {
            return;
        }

        if (Objects.isNull(consumer))
        {
            return;
        }

        CountDownLatch countDownLatch = new CountDownLatch(taskList.size());

        for (T couponOrShortMsg : taskList) {
            threadPool.execute(() -> {

                try {
                    consumer.accept(couponOrShortMsg);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
    }

    public static void disposeTask(String task)
    {
        System.out.println(String.format("【%s】disposeTask 下发优惠券或短信成功",task));
    }

    public static void disposeTaskV2(String task)
    {
        System.out.println(String.format("【%s】 disposeTask 下发邮件成功",task));
    }

    public static void disposeTaskV3(String task)
    {
        System.out.println(String.format("【%s】 disposeTask 下发二维码成功",task));
    }
}








