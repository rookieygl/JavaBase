package com.ygl.basic.concurrency.thread.creathread;


import java.util.concurrent.*;

class CallableTest implements Callable<String> {
    @Override
    public String call() {
        System.out.println(Thread.currentThread().getName() + ": Callable线程被执行");
        return Thread.currentThread().getName();
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        //构建线程池
        ExecutorService execservice = Executors.newFixedThreadPool(10);

        //线程池提交Callable
        FutureTask<String> ft = (FutureTask<String>) execservice.submit(new CallableTest());

        try {
            System.out.println("FutureTask收集的线程: " + ft.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //Future收集线程结果
        Future<String> future = execservice.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "正在行军~~~");
            System.out.println(Thread.currentThread().getName() + "遭遇敌军~~~");
            System.out.println(Thread.currentThread().getName() + "奋勇杀敌！！！！");
            return "战斗胜利，俘虏敌军50000人";
        });

        try {
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        //关闭线程池
        execservice.shutdown();
    }
}