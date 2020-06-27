package com.ygl.basic.concurrency.waitnotify;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/23 22:53
 * @DESC: rookie stronger
 **/
public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        Thread thread = new WaitThred(object);
        thread.start();
        Thread.sleep(2000);

        Thread notifyThred = new NotifyThred(object);
        notifyThred.start();

//
//
//        synchronized (object){
//            System.out.println("线程开始等待");
//            object.wait();
//            System.out.println("线程开始");
//        }
    }

}

class WaitThred extends Thread{
    private Object lock;

    public WaitThred(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock){
            System.out.println("线程开始等待");
            try {
                lock.wait(); //wait后的代码 在未被唤醒时 无法执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程等待结束");
        }
    }
}


class NotifyThred extends Thread{
    private Object lock;

    public NotifyThred(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        System.out.println("唤醒线程");
       synchronized (lock){//唤醒时，必须加锁 否则 monitor异常
           lock.notify();
           try {
               Thread.sleep(1000);
               System.out.println("唤醒等待");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
