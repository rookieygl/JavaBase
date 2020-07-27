package com.ygl.basic.concurrency.thread.creathread;

class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class RunnableDemo {
    public static void main(String[] args) {

        //Runnable通过start启动的
        new Thread(new RunnableTest(), "runableThread").start();

        //lamda函数创建
        Runnable anonRunable = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        //Runnable包装成线程对象。
        new Thread(anonRunable, "anonRunable1").start();
        //可以简写成如下形式
        new Thread(() -> System.out.println(Thread.currentThread().getName() +"lamda 创建"),"anonRunable2").start();

        //lamda匿名实现,默认属于父线程
        //等价于System.out.println(Thread.currentThread().getName() + ":匿名内部类创建线程");
        ((Runnable) () -> {
            System.out.println("匿名创建线程，默认为当前线程");
            System.out.println(Thread.currentThread().getName());
        }).run();
    }
}
