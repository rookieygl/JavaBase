package com.ygl.basic.concurrency.deadlock;

/**
 * @USER: rookie_ygl
 * @DATE: 2020/6/1
 * @TIME: 21:306
 **/
public class DeathLock {
    public static void main(String[] args) {
        DeathThread deathThread1 = new DeathThread();

        deathThread1.setThreadFlag(1);
        Thread thread1 = new Thread(deathThread1, "deathThread1");
        thread1.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deathThread1.setThreadFlag(2);
        Thread thread2 = new Thread(deathThread1, "deathThread2");
        thread2.start();
    }

}

class DeathThread extends Thread {
    public Integer threadFlag;

    public void setThreadFlag(Integer threadFlag) {
        this.threadFlag = threadFlag;
    }

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();


    @Override
    public void run() {
        if (threadFlag == 1) {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " lock1");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " lock2");
                }
            }
        }

        if (threadFlag == 2) {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " lock2");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " lock1");
                }
            }
        }
    }
}