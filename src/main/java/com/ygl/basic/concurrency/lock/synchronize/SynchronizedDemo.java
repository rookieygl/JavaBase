package com.ygl.basic.concurrency.lock.synchronize;

import java.util.concurrent.TimeUnit;

public class SynchronizedDemo {
    
    public static void main(String[] args) throws InterruptedException{
        SynchronizedDemo synchronizedDemo = new SynchronizedDemo();
        Thread t1 = new Thread(synchronizedDemo::synchMethod,"T1");
        t1.start();

        Thread t2 = new Thread(synchronizedDemo::synchMethod,"T2");
        t2.start();

        /**
         * 缺陷1： 无法控制等待时间。t1占用线程，只能阻塞，无法主动美好放弃
         * 缺陷2： 无法捕获中断信号，即上述阻塞无法被释放，sleep和wait可以
         */
    }

    public synchronized void synchMethod(){
        try {
            TimeUnit.HOURS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

}
