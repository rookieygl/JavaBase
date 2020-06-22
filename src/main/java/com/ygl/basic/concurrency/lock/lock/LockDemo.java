package com.ygl.basic.concurrency.lock.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/20 14:22
 * @DESC: rookie stronger
 **/
public class LockDemo {
    private Lock reentrantLock = new ReentrantLock();

    public void lock() {
        try {
            reentrantLock.lock();
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }
    }
}
