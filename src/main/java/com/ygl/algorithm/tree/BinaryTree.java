package com.ygl.algorithm.tree;

import java.util.*;

class BinaryNode {
    //节点值
    int   val;
    //左子节点引用
    BinaryNode  leftChild;
    //右子节点引用
    BinaryNode  rightChild;

    public void  printNode() {
        System.out.println(val);
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        //Hashtable
        //HashMap
        TreeMap treeMap  = new TreeMap();
        treeMap.put("zhang",6);
        treeMap.put("liu",1);
        treeMap.put("wang",6);
        treeMap.forEach((o, o2) -> {
            System.out.println(o);
        });

        //TreeSet treeSet = new TreeSet();
        //treeSet.add(1);
        //treeSet.add(1);
    }

}
