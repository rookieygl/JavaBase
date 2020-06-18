package com.ygl.basic.collection.linklist.singlylink;

import java.util.LinkedList;

class SinglyNode<E> {
	public E value;
	public SinglyNode<E> nextNode;

	public SinglyNode(E value) {
		this.value = value;
	}
}

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/7 18:47
 * @Desc:
 */
public class SinglyLinkTest<E> {

	private static SinglyNode head; // 头节点

	public static void main(String[] args) {
		SinglyLinkTest<Integer> singlyLinkTest = new SinglyLinkTest<>();
		singlyLinkTest.addNode(1);
		singlyLinkTest.addNode(2);
		singlyLinkTest.addNode(3);
		SinglyNode singlyNode = new SinglyNode(3);
		singlyLinkTest.printListReversely(head);
		LinkedList linkedList = new LinkedList();
		linkedList.getFirst();
	}

	/**
	 * 向链表中插入数据
	 *
	 * @param node
	 */
	public void addNode(E node) {

		SinglyNode<E> newNode = new SinglyNode<E>(node);// 实例化一个节点
		if (head == null) {
			head = newNode;
			return;
		}
		SinglyNode<E> tmp = head;
		while (tmp.nextNode != null) {
			tmp = tmp.nextNode;
		}
		tmp.nextNode = newNode;
	}

	/**
	 * @param index:删除第index个节点
	 * @return
	 */
	public boolean deleteNode(int index) {
		if (index < 1 || index > length()) {
			return false;
		}
		if (index == 1) {
			head = head.nextNode;
			return true;
		}
		int i = 1;
		SinglyNode<E> preNode = head;
		SinglyNode<E> curNode = preNode.nextNode;
		while (curNode != null) {
			if (i == index) {
				preNode.nextNode = curNode.nextNode;
				return true;
			}
			preNode = curNode;
			curNode = curNode.nextNode;
			i++;
		}
		return false;
	}

	/**
	 * @return 返回节点长度
	 */
	public int length() {
		int length = 0;
		SinglyNode<E> tmp = head;
		while (tmp != null) {
			length++;
			tmp = tmp.nextNode;
		}
		return length;
	}

	/**
	 * 在不知道头指针的情况下删除指定节点
	 *
	 * @param singlyNode
	 * @return
	 */
	public boolean deleteNodeByNoHead(SinglyNode<E> singlyNode) {
		if (singlyNode == null || singlyNode.nextNode == null) {
			return false;
		}
		E tmpNodeData = singlyNode.value;
		singlyNode.value = (E) singlyNode.nextNode.value;
		singlyNode.nextNode.value = tmpNodeData;
		singlyNode.nextNode = singlyNode.nextNode.nextNode;
		System.out.println("删除成功！");
		return true;
	}

	/**
	 * 输出链表
	 */
	public void printList(SinglyNode head) {
		SinglyNode<E> tmp = head;
		while (tmp != null) {
			System.out.println(tmp.value);
			tmp = tmp.nextNode;
		}
	}

	/**
	 * @param headNode
	 * @return
	 */
	public SinglyNode<E> reverseLink(SinglyNode<E> headNode) {
		//调换头节点
		SinglyNode<E> reverseHead = head;
		//当前节点 头节点开始 因为是单向链表 不存在尾节点
		SinglyNode<E> currNode = head;

		//下一节点
		SinglyNode<E> pNext = null;

		//临时节点
		SinglyNode<E> tmpNode = null;

		while (currNode != null) {
			pNext = currNode.nextNode;
			if (pNext == null) {
				//pNext为空 即为最后一个节点 直接作为头节点
				reverseHead = currNode;
			}
			//仅相邻两个节点调换顺序
			currNode.nextNode = tmpNode;
			tmpNode = currNode;
			currNode = pNext;
		}
		this.head = reverseHead;
		return this.head;
	}

	/**
	 * 查找单链表的中间节点
	 *
	 * @param head
	 * @return
	 */
	public SinglyNode SearchMid(SinglyNode head) {
		SinglyNode p = this.head, q = this.head;
		while (p != null && p.nextNode != null && p.nextNode.nextNode != null) {
			p = p.nextNode.nextNode;
			q = q.nextNode;
		}
		System.out.println("Mid:" + q.value);
		return q;
	}

	public void printListReversely(SinglyNode pListHead) {
		if (pListHead != null) {
			printListReversely(pListHead.nextNode);
			System.out.println("printListReversely:" + pListHead.value);
		}
	}

}
