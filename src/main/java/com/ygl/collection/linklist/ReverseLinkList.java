package com.ygl.collection.linklist;

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
		// 打印反转前的链表
		Node h = head;
		int n = 0;
		Node rnode = reverseByRecursive(head);
		while (head != null) {
//            System.out.print(head.data + " ");
			head = head.nextNode;
			n++;
		}

		boolean b = curLink(5, head, rnode);
		System.out.println(b);

	}

	/**
	 * 插入数据节点
	 *
	 * @param header
	 * @param curNode
	 * @return
	 */
	public static Node insert(Node header, Node curNode) {
		Node temp = header;    //一个移动的指针(把头结点看做一个指向结点的指针)
		while (temp.nextNode != null) {    //遍历单链表，直到遍历到最后一个则跳出循环。
			temp = temp.nextNode;        //往后移一个结点，指向下一个结点。
		}
		temp.nextNode = curNode;    //temp为最后一个结点或者是头结点，将其next指向新结点
		return null;

	}

	public static boolean curLink(int n, Node rNode, Node node) {
		while (node != null && rNode != null) {
			for (int j = n; j < 0; j--) {
				if (node.data != rNode.data) {
					return false;
				}
			}
			node = node.nextNode;
			rNode = rNode.nextNode;
		}
		return true;
	}

	/**
	 * 把当前节点的下一节点设为自己
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
		// 反转后，尾部成为头节点
		return rHead;
	}

	//遍历反转
	public static Node reverseByList(Node node) {
		Node pre = null;
		Node nextNode = null;
		while (node != null) {
			//存储下一节点
			nextNode = node.nextNode;
			//上一节点设为当前节点的下一个节点
			node.nextNode = pre;
			//当前节点设为下一次的上一个节点
			pre = node;
			//下一节点进入循环
			node = nextNode;
		}
		return pre;
	}
}