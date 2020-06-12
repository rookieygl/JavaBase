package com.ygl.collection.queue;


/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/6/12 14:15
 * @Desc:
 */
public class CycleQueue {
	private int[] queue;
	private int head;
	private int tail;
	private boolean empty = true;

	public CycleQueue(int initialCapacity) {
		this.queue = new int[initialCapacity];
	}

	public int inert(int element) {
		if (empty == false && head == tail + 1) {
			throw new IndexOutOfBoundsException("queue is full");
		}
		queue[tail] = element;
		tail = (tail + 1) & (queue.length - 1);
		return element;
	}


}
