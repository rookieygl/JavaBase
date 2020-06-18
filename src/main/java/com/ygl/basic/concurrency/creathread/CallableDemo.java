package com.ygl.basic.concurrency.creathread;


import java.util.concurrent.*;

class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}

public class CallableDemo {
    public static void main(String[] args) {
        //线程池启动
        ExecutorService execservice = Executors.newFixedThreadPool(10);

        //外部类启动callable
        FutureTask<String> ft = (FutureTask<String>) execservice.submit(new CallableTest());

        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //匿名内部类
        Callable<String> cl = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "正在行军~~~");
                System.out.println(Thread.currentThread().getName() + "遭遇敌军~~~");
                System.out.println(Thread.currentThread().getName() + "奋勇杀敌！！！！");
                return "战斗胜利，俘虏敌军50000人";
            }
        };

        //lamda简写
        Callable<String> c2 = () -> {
            System.out.println(Thread.currentThread().getName() + "正在行军~~~");
            System.out.println(Thread.currentThread().getName() + "遭遇敌军~~~");
            System.out.println(Thread.currentThread().getName() + "奋勇杀敌！！！！");
            return "战斗胜利，俘虏敌军50000人";

        };

        Future<String> future = execservice.submit(c2);
//        Future<String> future1 = execservice.submit(c2);
//        Future<String> future2 = execservice.submit(c2);
        try {
//           线程方式启动
//            FutureTask<String> ft = new FutureTask(c2);
//            new Thread(ft, "李存孝部队").start();
//            System.out.println(ft.get());


            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}