package com.ygl.basic.collection.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.TreeMap;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/22 11:44
 * @Desc:
 */
@Slf4j

public class TreeTrave {
	static class Node {
		public Integer val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int e) {
			val = e;
		}
	}

	private static Node root;

	public static void main(String[] args) {
		TreeTrave treeTest = new TreeTrave();
		int[] nodeArr = new int[]{5, 1, 2, 3, 4};
		root = new Node();
		for (int value : nodeArr) {
			treeTest.insertNode(root, value);
		}
		treeTest.modOrder(root);
	}

	/**
	 * 构建二叉搜索树
	 *
	 * @param node
	 */
	public void insertNode(Node node, int val) {
		if (node == null) {
			throw new IllegalArgumentException("根节点为空");
		}
		if (node.val == null || node.val <= 0) { //根节点为空
			node.val = val;
		} else if (node.val > val) {
			if (node.left == null) {
				node.left = new Node(val);
			} else {
				insertNode(node.left, val);
			}
		} else {
			if (node.right == null) {
				node.right = new Node(val);
			} else {
				insertNode(node.right, val);
			}
		}
	}

	/**
	 * 中序遍历,二叉树有序遍历 重点
	 *
	 * @param node
	 */
	public void modOrder(Node node) {
		if (node != null) {
			modOrder(node.left);
			System.out.println(node.val);
			modOrder(node.right);
		}
	}

	//1.前序遍历
	public void preOrder(Node node) {
		if (node != null) {
			System.out.println(node.val);
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	//3.后序遍历
	public void follOrder(Node node) {
		if (node != null) {
			follOrder(node.left);
			follOrder(node.right);
			System.out.println(node.val);
		}
	}

}
