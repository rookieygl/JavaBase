package com.ygl.algorithm.linklist;

import com.sun.corba.se.spi.ior.iiop.IIOPFactories;
import org.apache.hadoop.yarn.webapp.hamlet.Hamlet;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/27 18:39
 * @DESC: rookie stronger
 * <p>
 * 单向链表环问题
 **/
public class LinkListRing {
    static class Node {
        private Node nextNode;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.nextNode = node2;
        node2.nextNode = node3;
        node3.nextNode = node4;
        node4.nextNode = node5;
        node5.nextNode = node2;

        boolean cycle = isCycle(node1);
        System.out.println(cycle);

        findCyceleNode(node1);
        int length = countCycleLength(node1);
        System.out.println(length);
    }

    /**
     * 判断链表是否有环
     *
     * @param node 链表头
     * @return 环 flag
     */
    private static boolean isCycle(Node node) {
        Node firstNode = node;
        Node secondNode = node;

        while (secondNode != null && secondNode.nextNode != null) {
            //环只存在一个点
            //            //只需要第二个指针比第一个快即可
            //只要有环，第二个总会多走一定的圈数赶上第一个节点
            firstNode = firstNode.nextNode;
            secondNode = secondNode.nextNode.nextNode;
            //如果能相遇，说明有环，结束循环，返回true
            if (firstNode == secondNode) {
                return true;
            }
        }

        return false;
    }

    /**
     * 寻找入环点
     *
     * 根据计算公式得出：
     *  相遇点到入环点的距离和头节点到入环点的距离相等
     * @param header 链表头
     */
    public static Node findCyceleNode(Node header) {

        Node insertCycle = null;
        if (isCycle(header)) {
            Node firstNode = header;//慢指针
            Node secondNode = header;//快指针

            //获取相遇点的节点
            while (secondNode != null && secondNode.nextNode != null) {
                firstNode = firstNode.nextNode;
                secondNode = secondNode.nextNode.nextNode;
                if (firstNode == secondNode) {
                    //到相遇点，让一个指针回到链表头，这里重置快指针
                    firstNode = header;
                    break;
                }
            }

            //获取相遇点，重置头指针后，让快慢指针一样的速度相遇，即可得到入环点
            while (secondNode != null && secondNode.nextNode != null) {
                firstNode = firstNode.nextNode;
                secondNode = secondNode.nextNode;
                if (firstNode == secondNode) {
                    insertCycle = firstNode;
                    break;
                }
            }
        }
        return insertCycle;
    }

    /**
     * 计算环长
     *  快慢指针，第二次相遇即可得出环长
     *
     * @param header 链表头
     * @return
     */
    private static int countCycleLength(Node header) {
        //环长
        int length = 0;
        if (isCycle(header)) {
            //环圈数
            int round = 0;

            Node firstNode = header;//快指针
            Node secondNode = header;//慢指针

            //让快慢指针差速移动，计算链表环
            while (secondNode != null && secondNode.nextNode != null) {
                //在第一圈后，开始计算环长
                if (round == 1) {
                    length++;
                }
                firstNode = firstNode.nextNode;
                secondNode = secondNode.nextNode.nextNode;
                if (firstNode == secondNode) {
                    round++;
                    //超出一圈，终止循环
                    if (round > 1) {
                        break;
                    }
                }
            }
        }
        return length;
    }
}
