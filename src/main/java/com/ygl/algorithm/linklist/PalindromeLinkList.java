package com.ygl.algorithm.linklist;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/27 15:51
 * @DESC: rookie stronger
 *
 * 判断单向链表是否是 回文链表
 **/
public class PalindromeLinkList {
    static class Node {
        private Node nextNode;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        insertNode(head, 2);
        insertNode(head, 3);
        insertNode(head, 4);
        insertNode(head, 3);
        insertNode(head, 2);
        insertNode(head, 1);

        //构建一个一样的链表，方便回文检查
        Node oldHead = new Node(1);
        insertNode(oldHead, 2);
        insertNode(oldHead, 3);
        insertNode(oldHead, 4);
        insertNode(oldHead, 3);
        insertNode(oldHead, 2);
        insertNode(oldHead, 1);

        //输出链表
        Node traveLink = head;
        while (traveLink != null) {
            System.out.println(traveLink.val);
            traveLink = traveLink.nextNode;
        }


        System.out.println("反转链表");
        //获取反转后的链表头
        Node rNode = reverseLink(head);
        //获取反转前的链表头
        Node palinHead = oldHead;
        //回文flag
        boolean isPalindrome = true;
        while (rNode != null && palinHead != null) {
            //回文值不等，结束循环，设置为false
            if (rNode.val != palinHead.val) {
                isPalindrome = false;
                break;
            }
            rNode = rNode.nextNode;
            palinHead = palinHead.nextNode;
        }

        System.out.println("是否是回文链表" + isPalindrome);
    }


    /**
     * 插入链表
     *
     * @param head 链表头
     * @param val 节点值
     */
    public static void insertNode(Node head, int val) {
        Node node = new Node(val);
        Node tmp = head;
        while (tmp.nextNode != null) {
            tmp = tmp.nextNode;
        }
        tmp.nextNode = node;
    }

    /**
     * 反转链表
     *
     * @param node 链表头
     * @return
     */
    public static Node reverseLink(Node node) {
        if (node == null || node.nextNode == null) {
            return node;
        }

        Node rHead = reverseLink(node.nextNode);
        node.nextNode.nextNode = node;
        node.nextNode = null;
        return rHead;
    }

}
