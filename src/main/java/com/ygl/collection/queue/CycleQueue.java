package com.ygl.collection.queue;


import java.util.ArrayList;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/6/12 14:15
 * @Desc:
 */
public class CycleQueue {
    private int[] queue; //队列容器
    private int head;
    private int tail;
    private boolean empty = true;
	private static final int DEFAULT_CAPACITY = 10;
	public CycleQueue() {
		this.queue = new int[DEFAULT_CAPACITY];
	}

    public CycleQueue(int initialCapacity) {
		if (initialCapacity>0){
			this.queue = new int[initialCapacity];
		}else {
			this.queue = new int[DEFAULT_CAPACITY];
		}
    }

	public static void main(String[] args) {
		CycleQueue cycleQueue = new CycleQueue();
		cycleQueue.offer(1);
		cycleQueue.offer(2);
		cycleQueue.offer(3);
		int[] queue = cycleQueue.queue;
		for (int i = 0; i < queue.length; i++) {
//			System.out.println(queue[i]);
		}

		System.out.println(cycleQueue.pook());
	}

    public int pook() {
        if (empty) {
            return 0;
        }
        int headEle = queue[head];
		head = (head + 1) & (queue.length - 1);
        return headEle;
    }

    public int offer(int element) {
        if (!empty && head == tail + 1) {
            throw new IndexOutOfBoundsException("queue is full");
        }
        queue[tail] = element;
        tail = (tail+1) %(queue.length);
        return element;
    }


}
