package com.ygl.collection.linklist.singlylink;

/**
 * @author zhaopeng
 * @create 2019-12-30 20:57
 */
public class SinglyIndexLinkTest<E> {
    //定义一个节点类
    private class Node {
        public E data;
        public Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public Node() {
            this(null, null);
        }
    }

    private int size;//定义长度属性

    private Node head;//定义头结点

    public SinglyIndexLinkTest() {
        head = new Node(null, null);//一个空的头结点
    }

    //得到长度
    public int getSize() {
        return size;
    }

    //根据索引位置进行插入值
    public void add(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界,插入失败！！！");
        }
        Node tempNode = head;//创建一个临时的节点指向头结点的下一个节点
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        Node newNode = new Node(data);
        newNode.next = tempNode.next;
        tempNode.next = newNode;
        size++;
    }

    //在头结点后加入值
    public void addFirst(E data) {
        add(0, data);
    }

    //在尾节点后加入值
    public void addLast(E data) {
        add(size, data);
    }

    //根据索引返回值
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界,获取值失败！！！");
        }
        Node tempNode = head.next;//创建一个临时的节点指向头结点的下一个节点
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        return tempNode.data;
    }

    //得到链表头的值
    public E getFirst() {
        return get(0);
    }

    //得到链表尾的值
    public E getLast() {
        return get(size - 1);
    }


    //是否存在data值
    public boolean contains(E data) {
        Node node = head.next;
        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
        }
        return false;
    }

    //根据索引设置值
    public void set(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界,设置失败！！！");
        }
        Node tempNode = head.next;//创建一个临时的节点指向头结点的下一个节点
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        tempNode.data = data;
    }

    //设置第一个节点的值
    public void setFirst(E data) {
        set(0, data);
    }

    //设置最后一个节点的值
    public void setLast(E data) {
        set(size - 1, data);
    }

    //执行删除操作
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("索引越界,删除失败！！！");
        }
        Node tempNode = head;//创建一个临时的节点指向头结点的下一个节点
        for (int i = 0; i < index; i++) {
            tempNode = tempNode.next;
        }
        Node resNode = tempNode.next;
        E data = resNode.data;
        tempNode.next = tempNode.next.next;
        resNode = null;
        size--;
        return data;
    }

    //删除第一个节点的值
    public E removeFirst() {
        return remove(0);
    }

    //删除最后一个节点的值
    public E removeLast() {
        return remove(size - 1);
    }

    //重写toString方法
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList:head-->");
        Node tempNode = head.next;
        while (tempNode != null) {
            res.append(tempNode.data + "-->");
            tempNode = tempNode.next;
        }
        res.append("NULL");
        return res.toString();
    }
}