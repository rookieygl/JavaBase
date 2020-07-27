package com.ygl.algorithm.dynamicProgram;

/**
 * @Project: open sources
 * @Author: ygl
 * @Date: 2020/7/22 10:24
 * @Desc: 连续数组最大和
 */
public class ContArrayMaxSum {
	public static void main(String[] args) {
		System.out.println(getArrayMaxProduct(new int[]{1, 8, -5, 0}));
	}

	/**
	 * @param arr 数组
	 * @return
	 */
	public static int getArrayMaxProduct(int[] arr) {
		int dpMax = arr[0];
		for (int i = 1; i < arr.length; i++) {
			dpMax = Math.max(dpMax, dpMax + arr[i]);
		}
		return dpMax;
	}

}
