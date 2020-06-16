package com.ygl.collection.linklist.singlylink;

class Node {
	public int data;// 数据域
	public Node nextNode;// 指针域

	public Node(int data) {
		this.data = data;
	}

}

public class ReverseLinkList {
	public static void main(String[] args) {
		Node head = new Node(1);
		insert(head, new Node(2));
		insert(head, new Node(3));
		insert(head, new Node(2));
		insert(head, new Node(1));
		Node rnode = reverseByList(head);
		while (rnode.nextNode != null) {
			System.out.println(rnode.data);
			rnode = rnode.nextNode;
		}

	}

	/**
	 * 插入数据节点
	 *
	 * @param header
	 * @param curNode
	 * @return
	 */
	public static void insert(Node header, Node curNode) {
		Node temp = header;    //一个移动的指针(把头结点看做一个指向结点的指针)
		while (temp.nextNode != null) {    //遍历单链表，直到遍历到最后一个则跳出循环。
			temp = temp.nextNode;        //往后移一个结点，指向下一个结点。
		}
		temp.nextNode = curNode;    //temp为最后一个结点或者是头结点，将其next指向新结点
	}

	/**
	 * 递归反转链表
	 * 把当前节点的下一节点设为自己
	 * 设置后，节点关系改变，因此只能倒序操作
	 *
	 * @param node
	 * @return
	 */
	public static Node reverseByRecursive(Node node) {
		// head看作是前一结点，head.getNext()是当前结点，reHead是反转后新链表的头结点
		if (node == null || node.nextNode == null) {
			return node;// 若为空链或者当前结点在尾结点，则直接还回
		}

		Node rHead = reverseByRecursive(node.nextNode);
		//把当前节点的下一节点设为自己
		node.nextNode.nextNode = node;
		//防止死环，将当前节点的下一节点设置为null
		node.nextNode = null;
		//反转后，尾部成为头节点
		return rHead;
	}

	/**
	 * 遍历反转列表
	 * 当前节点指向上一节点（头节点指向空）
	 *
	 * @param node
	 * @return
	 */
	public static Node reverseByList(Node node) {
		Node pre = null;
		Node nextNode = null;
		while (node != null) {
			//临时下一节点
			nextNode = node.nextNode;
			//当前的下一节点指向前一节点，完成反转
			node.nextNode = pre;
			//当前节点设置下一节点的前一节点
			pre = node;
			//下一节点进入循环
			node = nextNode;
		}
		return pre;
	}

	public static Node reversePosition(Node node, int start, int end) {
		return node;
	}

}