package com.ygl.basic.concurrency.thread.creathread;

class ThreadTest extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("ThreadTest");
        System.out.println( Thread.currentThread().getName());
    }
}

/**
 * java里面只有一个thread类，最终都输thread的run方法实现逻辑
 *
 * start0 JNI启动线程一个线程只能被启动一次
 * 该逻辑由threadStatus控制
 */
public class ThreadDemo {
    public static void main(String[] args) {
        Thread thread = new ThreadTest();
        thread.setName("Thread的ThreadTest");
        thread.start();

        testGroup(thread);//测试线程组

        //匿名内部类
        Thread anonThrean = new Thread("anonThrean"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        anonThrean.start();

        //lamda简化代码实现
        new Thread(()-> {
                Thread.currentThread().setName("lamdaThread");
                System.out.println(Thread.currentThread().getName());
            }
        ).start();

    }

    /**
     * 测试线程组
     *
     * @param thread
     */
    public static void testGroup(Thread thread){
        //线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println(thread.getThreadGroup().getName());
        System.out.println(mainGroup.getName());
    }
}
