package com.ygl.basic.collection.queue;


/**
 * @Project: open sources
 * @Author: ygl
 * @Date: 2020/6/12 14:15
 * @Desc:
 */
public class CycleQueue<E> {
	private E[] queue; //队列容器
	private int head;
	private int tail;
	private static final int DEFAULT_CAPACITY = 10;

	public CycleQueue() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * 默认有参构造器
	 *
	 * @param initialCapacity
	 */
	public CycleQueue(int initialCapacity) {
		if (initialCapacity > 0) {
			this.queue = (E[]) new Object[initialCapacity];
		} else {
			this.queue = (E[]) new Object[DEFAULT_CAPACITY];
		}
	}

	public static void main(String[] args) {
		CycleQueue<Object> cycleQueue = new CycleQueue<>();
		//cycleQueue.offer(1);
		//cycleQueue.offer(2);
		//cycleQueue.offer(3);
		//cycleQueue.offer(3);
		//cycleQueue.offer(3);
		//cycleQueue.offer(3);
		//cycleQueue.offer(3);
		//cycleQueue.offer(3);
		//cycleQueue.offer(3);
		//cycleQueue.offer(3);
		System.out.println(cycleQueue.pook());
		//System.out.println(cycleQueue.pook());
		//System.out.println(cycleQueue.pook());
		//System.out.println(cycleQueue.pook());
	}

	/**
	 * 出队
	 *
	 * @return
	 */
	public E pook() {
		if (tail == tail) {
			throw new IllegalArgumentException("queue is empty");
		}
		E headEle = queue[head];
		queue[head] = null;
		head = (head + 1) % (queue.length - 1);
		return headEle;
	}

	/**
	 * 入队
	 *
	 * @param element
	 */
	public void offer(E element) {
		if ((tail + 1) % queue.length == head) {
			throw new IndexOutOfBoundsException("queue is full");
		}
		queue[tail] = element;
		tail = (tail + 1) % (queue.length);
	}
}
