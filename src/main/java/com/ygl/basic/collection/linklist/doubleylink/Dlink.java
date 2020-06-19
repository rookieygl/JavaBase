package com.ygl.basic.collection.linklist.doubleylink;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/7 18:50
 * @Desc:
 */
public class Dlink {

    static class Node{
        public Node next;
        public Node pre;
        public int val;
        private int size;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;


    public static Node inertNode(Node node,int val){

        return null;
    }

}
