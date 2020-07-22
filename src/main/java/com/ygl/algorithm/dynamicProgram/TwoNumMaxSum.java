package com.ygl.algorithm.dynamicProgram;

import java.util.Stack;

/**
 * @Project open sources
 * @Author: rookie_ygl
 * @DATE: 2020/6/21 21:46
 * @DESC: rookie stronger
 **/
public class TwoNumMaxSum {
	public static void main(String[] args) throws Exception {
		int[] values = new int[]{3, 7, 1, 3, 9};
		System.out.println(getTwoNumMaxSum(values, 2));
	}


	public static int getTwoNumMaxSum(int[] arr, int num) throws Exception {
		for (int value : arr) {
			TwoNumMaxSum.push(value);
		}

		int maxSum = 0;
		for (int i = 0; i < num; i++) {
			maxSum += TwoNumMaxSum.pop();
		}

		return maxSum;
	}

	private static Stack<Integer> mainStack = new Stack<>();//主栈
	private static Stack<Integer> minStack = new Stack<>();//辅助最小栈

	/**
	 * push一个新元素，入栈
	 * 同时保存最大元素
	 *
	 * @param element 入栈元素
	 */
	public static void push(int element) {
		mainStack.push(element);

		//如果辅助栈为空，或者新元素小于等于辅助栈栈顶，将新元素压入辅助栈
		if (minStack.empty() || element >= minStack.peek()) {
			minStack.push(element);
		}
	}


	/**
	 * 最大元素出栈
	 *
	 * @return
	 */
	public static Integer pop() throws Exception {
		//如果出栈元素和辅助栈栈顶元素相等，辅助栈出栈
		if (minStack.empty()) {
			throw new Exception("");
		}
		//存在相同元素，最小栈也要出栈一个元素
		return minStack.pop();

	}


	/**
	 * 获取数组中两数最大和
	 *
	 * @param values    数组
	 * @param rodLength 数组长度
	 * @return
	 */
	public static int getValue(int[] values, int rodLength) {
		int[] subSolutions = new int[rodLength + 1];

		for (int i = 0; i <= rodLength; i++) {
			int tmpMax = values[0];
			for (int j = 1; j < i; j++)
				tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]);
			subSolutions[i] = tmpMax;
		}
		return subSolutions[rodLength];
	}
}
