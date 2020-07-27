package com.ygl.basic.concurrency.thread.creathread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/7/27 16:26
 * @DESC: rookie stronger
 **/

public class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        //循环创建线程，newFixedThreadPool线程池限定了5个线程，循环中超出的线程不会被创建。
        //除非前5个线程中遇到异常被打断。
        for (int i = 0; i < 8; i++) {
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "线程被调用了。");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        //关闭线程池
        executorService.shutdown();
    }
}
