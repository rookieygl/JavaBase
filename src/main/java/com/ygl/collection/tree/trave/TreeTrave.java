package com.ygl.collection.tree.trave;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

public class TreeTrave {
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeTrave treeTest = new TreeTrave();
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        //TreeNode right1 = new TreeNode(4);
        treeNode.left = left;
        treeNode.right = right;
        //right.left = right1;
        treeTest.preOrder(treeNode);
        System.out.println("前序遍历" + list.toString());
        treeTest.modOrder(treeNode);
        System.out.println("中序遍历" + list.toString());
        //treeTest.inorder1(treeNode);
        //System.out.println("中序遍历"+list.toString());
    }

    //前序遍历
    public void preOrder(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //中序遍历,递归实现
    public void modOrder(TreeNode root) {
        if (root != null) {
            modOrder(root.left);
            list.add(root.val);
            modOrder(root.right);
        }
    }

    //
    public void stackNode(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
    }

    //3.后序遍历
    public void follOrder(TreeNode root) {
        if (root != null) {
            follOrder(root.left);
            follOrder(root.right);
            list.add(root.val);
        }
    }
}
