package com.ygl.algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/22 11:44
 * @Desc:
 */
class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

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
		treeNode.left = left;
		treeNode.right = right;

		treeTest.modOrder(treeNode);
		System.out.println("前序遍历" + list.toString());
		//treeTest.inorder1(treeNode);
		//System.out.println("中序遍历"+list.toString());
	}

	//1.前序遍历
	public void preOrder(TreeNode root) {
		if (root != null) {
			list.add(root.val);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	//2.1中序遍历,递归实现
	public void modOrder(TreeNode root) {
		if (root != null) {
			stackNode(root.left);
			list.add(root.val);
			stackNode(root.right);
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
}
