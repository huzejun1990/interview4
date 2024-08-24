package com.dream.interview4.juc;

import lombok.Getter;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.data.redis.stream.Task;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 正确关闭线程池姿势--优雅停机
 *
 * @Author : huzejun
 * @Date: 2024/8/12-2:13
 */
public class ThreadPoolGracefulShutdownDemo {

    public static void main(String[] args) {

//        shutdown_Test();
        shutdownNow_Test();
/*        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try {

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
            threadPool.shutdownNow();

            //生产级别，如何优雅停机，关闭线程池
            finalOK_shutdownAndAwaitTermination(threadPool);
        }*/

    }


    /**
     * 参考官网停用，最后的终结，优雅关停，但是有点费事儿
     *
     * @param threadPool
     */
    private static void finalOK_shutdownAndAwaitTermination(ExecutorService threadPool) {
        if (threadPool != null && !threadPool.isShutdown()) {
            threadPool.shutdown();

            try {
                if (!threadPool.awaitTermination(120, TimeUnit.SECONDS)) {
                    threadPool.shutdown();
                    if (!threadPool.awaitTermination(120, TimeUnit.SECONDS)) {
                        System.out.println("Pool did not terminate");
                    }
                }
            } catch (InterruptedException ie) {
                threadPool.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

    }

    /**
     * 调用 shutdownNow 后，第一个任务正在睡眠的时候，触发了 interrupt 中断
     * 之前等待的任务2~5被从队列中清除并返回，之后的任务6~10被拒绝
     * but
     * shutdown 方法将线程池状态置为 STOP，试图让线程池立刻停止。
     * 但不一定能保证立即停止，要等所有正在执行的任务（不能被 interrupt 中断的任务） 执行完才能停止
     */
    private static void shutdownNow_Test() {
        //一池一个线程
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 10; i++) {

            try {
                threadPool.execute(new Task(i));
            } catch (RejectedExecutionException e) {
                System.out.println("rejected, task-" + i);
            }
            if (i == 5) {
                List<Runnable> tasks = threadPool.shutdownNow();
                for (Runnable task : tasks) {
                    if (task instanceof Task) {
                        System.out.println("waiting task: " + ((Task) task).getName());
                    }
                }
            }
        }

    }

    /**
     * 第6个任务开始及之后的任务都被拒绝了，1~5号任务正常执行。
     * 所以 shutdown 方法将线程池状态设置为 SHUTDOWN,线程池并不会立即停止，
     * 要等正在执行和队列里等待的任务执行完才会停止
     */
    private static void shutdown_Test() {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //提交10个任务，在第5个任务提交完，准备提交第6个的时候执行shutdown
        for (int i = 1; i <= 10; i++) {
            System.out.println("第：" + i + " 次提交");
            //此处不加 try ...catch块，方便效果演示
            threadPool.execute(new Task(i));

            if (i == 5) {
                threadPool.shutdown();
            }
        }
    }

    /**
     * 线程执行的任务
     */
    static class Task implements Runnable {

        @Getter
        String name = "";

        public Task(int i) {
            name = "task-" + i;
        }

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("sleep completed, " + getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("interrupted, " + getName());
                return;
            }
            System.out.println(getName() + "finished");
            System.out.println();
        }
    }
}
