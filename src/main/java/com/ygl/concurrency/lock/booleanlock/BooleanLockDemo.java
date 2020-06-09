package com.ygl.concurrency.lock.booleanlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * lock() 默认方法，像synchronize会被永远阻塞,但是可以捕获中断
 * lock(long mills)
 * unlock() 锁释放
 * getBlockThreads()用于获取当前有那些线程被阻塞
 */
public class BooleanLockDemo implements Lock {

    private Thread curremtThread;

    private boolean lock = false;

    private final List<Thread> blockList = new ArrayList<>();

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
