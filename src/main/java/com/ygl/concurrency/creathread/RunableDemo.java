package com.ygl.concurrency.creathread;

class RunableTest implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class RunableDemo {
    public static void main(String[] args) {

        //new RunableTest() 继承threa的类是可以直接.start启动的 因为start是专属于run方法的
        new Thread(new RunableTest(),"runableThread").start();


        //匿名内部类实现
        Runnable anonRunable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        //线程任务对象包装成线程对象。
        Thread t = new Thread(anonRunable,"anonRunable");
        //启动线程。
        t.start();

        //lamda匿名实现 () 表示new了一个runable
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
