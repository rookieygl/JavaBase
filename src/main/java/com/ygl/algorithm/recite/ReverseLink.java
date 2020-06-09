package com.ygl.algorithm.recite;

class Node {
    public Node next;
    public Object data;

    public Node(Object data) {
        this.data = data;
    }
}

public class ReverseLink {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(2);
        Node node5 = new Node(1);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }

    private static Node reverseLink(Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        Node rHead = reverseLink(node.next);
        node.next.next = node;
        node.next = null;
        return rHead;
    }
}
