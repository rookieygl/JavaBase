package com.ygl.basic.collection.linklist.singlylink;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/7 18:47
 * @Desc:
 */
public class SinglyLink<E> {

    static class Node {
        public int value;
        public Node nextNode;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node head; // 头节点

    public static void main(String[] args) {
        SinglyLink<Integer> singlyLinkTest = new SinglyLink<>();
        singlyLinkTest.addNode(1);
        singlyLinkTest.addNode(2);
        singlyLinkTest.addNode(3);
        Node node = getNode(head, 2);
        System.out.println(node.value);
    }

    public static Node getNode(Node node, int index) {
        for (int i = index; i > 0; i--) {
            if (node != null) {
                node = node.nextNode;
            }
        }
         return node;
    }

    /**
     * 向链表中插入数据
     *
     * @param node
     */
    public void addNode(int node) {
        Node newNode = new Node(node);// 实例化一个节点
        if (head == null) {
            head = newNode;
            return;
        }
        Node tmp = head;
        while (tmp.nextNode != null) {
            tmp = tmp.nextNode;
        }
        tmp.nextNode = newNode;
    }
}
