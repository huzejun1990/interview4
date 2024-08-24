package com.dream.interview4.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author : huzejun
 * @Date: 2024/8/24-23:39
 */
@Slf4j
public class ThreadPoolExceptionDemo {
    public static void main(String[] args) {
//        defaultSubmit();

//        defaultSubmitAndGet();

//        defaultExecute();

        //==============
        handleException();

        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5)); //Executors.newFixedThreadPool(5);


    }

    /**
     * 池中线程抛异常了，覆写afterExecute方法,全部兼顾
     */
    private static void handleException() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                Runtime.getRuntime().availableProcessors() * 2,
                1L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(10)) {
            @Override
            protected void afterExecute(Runnable runnable, Throwable throwable) {
//                super.afterExecute(r, t);
                //execute运行
                if (throwable != null) {
                    log.error(throwable.getMessage(), throwable);
                }
                //submit运行
                if (throwable == null && runnable instanceof Future<?>) {
                    try {
                        Future<?> future = (Future<?>) runnable;
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (CancellationException ce) {
                        throwable = ce;
                        ce.printStackTrace();
                    } catch (ExecutionException ee) {
                        throwable = ee.getCause();
                        ee.printStackTrace();
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }

            }
        };

/*        threadPool.submit(() -> {
            //默认submit方法（不获取返回值）会吞掉异常，我们改写后可以抛出异常了
            System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法");
            int age = 20 / 0;
            System.out.println(Thread.currentThread().getName()+"\t"+"进入池中submit方法---end");
        });*/

        System.out.println();
        try { TimeUnit.MILLISECONDS.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();

        threadPool.execute(() -> {
            //execute会抛出异常
            System.out.println(Thread.currentThread().getName() + "\t" + "进入池中execute方法");
            for (int i = 1; i <= 4; i++) {
                if (i == 3) {
                    int age = 10 / 0;
                }
                System.out.println("---come in execute: "+i);
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"进入池中execute方法---end");

        });

        finalOK_ShutdownAndAwaitTermination(threadPool);
    }

    /**
     * 3 默认调用，execute会抛出异常。
     */
    private static void defaultExecute() {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        try {
            //3 默认调用execute会抛出异常。
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中execute方法");
                for (int i = 1; i <= 4; i++) {
                    if (i == 3) {
                        int age = 10 / 0;
                    }
                    System.out.println("---come in execute: " + i);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中execute方法---end");
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finalOK_ShutdownAndAwaitTermination(threadPool);
        }
    }

    /**
     * 参考官网使用，最后的终结，优雅关停，有点儿费事
     *
     * @param threadPool
     */
    private static void finalOK_ShutdownAndAwaitTermination(ExecutorService threadPool) {

        if (threadPool != null && !threadPool.isShutdown()) {
            threadPool.shutdown();

            try {
                if (!threadPool.awaitTermination(120, TimeUnit.SECONDS)) {
                    threadPool.shutdownNow();

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
     * 2 submit执行后，如果get方法调用想要获得返回值，会抛出异常
     */
    private static void defaultSubmitAndGet() {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        try {
            //2 submit执行后，如果不获取返回值异常被吞掉，但如果get方法调用获得返回值，会抛出异常
            Future<?> result = threadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法");
                int age = 20 / 0;
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法---end");
            });
            result.get();       //如果没有这一行，异常被吞
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }

    /**
     * 1 默认调用，submit会吞掉异常
     */
    private static void defaultSubmit() {

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        try {
            //1 默认调用，submit会吞掉异常
            threadPool.submit(() -> {
                //submit会吞掉异常
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法");
                for (int i = 1; i <= 4; i++) {
                    if (i == 3) {
                        int age = 10 / 0;
                    }
                    System.out.println("----come in execute: " + i);
                }
                System.out.println(Thread.currentThread().getName() + "\t" + "进入池中submit方法 ----end");
            });
            //res
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

}
