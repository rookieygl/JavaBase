package com.ygl.basic.collection.queue;

import java.io.Serializable;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Project: open sources
 * @Author: ygl
 * @Date: 2020/6/16 11:29
 * @Desc:
 */
public class DoubleQueue<T> {

	//队列的长度
	private int size;
	//队首
	private NodeData headNode;
	//队尾
	private NodeData tailNode;

	public DoubleQueue() {
		this.size = 0;
		this.headNode = null;
		this.tailNode = null;
	}

	//链表
	private class NodeData implements Serializable {
		private static final long serialVersionUID = 1L;
		//数据
		private T data;
		//头节点
		private NodeData front;
		//尾节点
		private NodeData next;

		public NodeData(T data, NodeData front, NodeData next) {
			super();
			this.data = data;
			this.front = front;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public NodeData getFront() {
			return front;
		}

		public void setFront(NodeData front) {
			this.front = front;
		}

		public NodeData getNext() {
			return next;
		}

		public void setNext(NodeData next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		BlockingQueue blockingDeque = new LinkedBlockingQueue();

		DoubleQueue<Integer> duQue = new DoubleQueue<>();
		duQue.addFrist(4);
		duQue.addFrist(3);
		duQue.addFrist(2);
		duQue.addFrist(1);
		duQue.addLast(5);
		duQue.addLast(6);
		System.out.println("头尾");
		System.out.println(duQue.headNode.data);
		System.out.println(duQue.tailNode.data);
		System.out.println("正序");
		duQue.foreachFirst();
		System.out.println("倒序");
		duQue.foreachLast();
	}

	/**
	 * 队头增加元素
	 */
	public void addFrist(T newEntry) {
		NodeData node = new NodeData(newEntry, null, headNode);
		if (isEmpty()) {
			tailNode = node;
		} else {
			headNode.setFront(node);
		}
		headNode = node;
		size++;
	}

	/**
	 * 移除头元素
	 */
	public T removeFrist() {
		T target = null;
		if (!isEmpty()) {
			target = headNode.getData();
			headNode = headNode.getNext();
			if (headNode == null) {
				tailNode = null;
			}
			size--;
		}
		return target;
	}

	/**
	 * 队尾增加元素
	 */
	public void addLast(T newEntry) {
		NodeData node = new NodeData(newEntry, tailNode, null);
		if (!isEmpty()) {
			tailNode.setNext(node);
		}
		tailNode = node;
		size++;
	}

	/**
	 * 移除队尾元素
	 */

	public T removeLast() {
		T target = null;
		if (!isEmpty()) {
			target = tailNode.getData();
			tailNode = tailNode.getFront();
			if (tailNode == null) {
				headNode = null;
			}
			size--;
		}
		return target;
	}

	/**
	 * 判断队列是否为空
	 */

	public boolean isEmpty() {
		return size <= 0;
	}

	/**
	 * 队列长度
	 */

	public int size() {
		return size;
	}

	/**
	 * 清除队列
	 */

	public void clear() {
		headNode = null;
		tailNode = null;
		size = 0;
	}

	/**
	 * 队首循环遍历队列
	 */
	public void foreachFirst() {
		if (isEmpty()) {
			throw new RuntimeException("当前队列为空");
		} else {
			int temp = size;
			while (temp > 0) {
				System.out.print(headNode.getData() + "\t");
				addLast(removeFrist());
				temp--;
			}
			System.out.println("======队列正序遍历完成======");
		}
	}

	/**
	 * 队尾循环遍历队列
	 */
	public void foreachLast() {
		if (isEmpty()) {
			throw new RuntimeException("当前队列为空");
		} else {
			int temp = size;
			while (temp > 0) {
				System.out.print(tailNode.getData() + "\t");
				addFrist(removeLast());
				temp--;
			}
			System.out.println("======队列倒序遍历完成======");
		}

	}

}
