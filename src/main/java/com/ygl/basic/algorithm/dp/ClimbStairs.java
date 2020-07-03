package com.ygl.basic.algorithm.dp;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/6/22 10:29
 * @Desc: 爬楼梯问题 一次只能爬一层或者两层
 */
public class ClimbStairs {
	public static void main(String[] args) {
		//int climbStairsRecursive = climbStairsRecursive(5);
		int climbStairsDP = climbStairsDP(5);
		System.out.println(climbStairsDP);
	}

	/**
	 * 递归求解 但是面对指数级增长并不是最优解
	 *
	 * @param n 楼梯个数
	 * @return 上楼方式
	 */
	private static int climbStairsDP(int n) {
		if (n < 3) {
			return n;
		}

		int[] f = new int[n + 1];
		f[0] = 1;
		f[1] = 2;

		for (int i = 2; i <= n - 1; i++) {
			//状态方程
			f[i] = f[i - 1] + f[i - 2];
		}
		//结果
		return f[n - 1];
	}

	/**
	 * 递归求解 但是面对指数级增长并不是最优解
	 *
	 * @param n 楼梯个数
	 * @return 上楼方式
	 */
	private static int climbStairsRecursive(int n) {
		if (n < 3) {
			return n;
		}
		//这里递归的公式；由步数决定，一次只能走一步或者两步，那么到最后一个台阶前就有n-1和n-2；两种情况的和
		return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
	}
}
