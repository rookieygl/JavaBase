package com.ygl.algorithm.LeetCode;


/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/7/22 11:28
 * @Desc: 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 如果数值是正序，最好倒序进行计算
 *
 * 初等数学
 * 通常取模运算也叫取余运算，它们返回结果都是余数，唯一的区别在于:
 * 当 x 和 y 的正负号一样的时候，两个函数结果是等同的；当 x 和 y 的符号不同时，rem函数结果的符号和 x 的一样，而 mod 和 y 一样。
 */

//Definition for singly-linked list
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class LC002TwoNumAdd {
	public static void main(String[] args) {
		//数字是逆序的，个位数是头结点
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(9);

		ListNode listNode = addTwoNumbers(l1, l2);

		//遍历输出和
		while (listNode != null) {
			System.out.print(listNode.val);
			listNode = listNode.next;
		}


	}

	/**
	 * 两个数相加
	 *
	 * @param l1 数字链表1
	 * @param l2 数字链表1
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//定义和结果的链表头结点。值为0，返回时移除
		ListNode pre = new ListNode(0);

		//预指针
		ListNode cur = pre;

		int carry = 0; //记录数值相加 溢出的情况
		while (l1 != null || l2 != null) {
			//值判断
			int x = l1 == null ? 0 : l1.val;
			int y = l2 == null ? 0 : l2.val;

			//最重要的一点，把和记录起来
			int sum = x + y + carry;

			//记录相加后总数和10的商。
			//如果不到10，商为0
			//超过10，最大值为19，商为1，下一轮相加
			carry = sum / 10;

			//记录sum和10的余数，只要余数，carry负责进位
			sum = sum % 10;

			//cur只每次相加的结果，最终数据在pre节点后面
			cur.next = new ListNode(sum);
			cur = cur.next;


			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		//如果最后需要进位，延长一个节点，将进位的1加入链表即可
		if (carry == 1) {
			cur.next = new ListNode(carry);
		}

		//pre第一个节点是0，相加结束，只返回头节点的下一个节点
		return pre.next;
	}

}
