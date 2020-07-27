package com.ygl.algorithm.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project: open sources
 * @Author: ygl
 * @Date: 2020/7/22 11:28
 * @Desc:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
 * 并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class LC001FindSumTwoNum {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;

		int[] ints = twoSum(nums, target);
		System.out.println(Arrays.toString(ints));
	}

	/**
	 *利用hash表，从第一个元素开始存在，不断获取元素值和差值是否存在
	 *
	 * 空间复杂度O(n),时间复杂度O(n)
	 *
	 * @param nums 数组
	 * @param target 目标数值
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		//遍历数值
		for (int i = 0; i < nums.length; i++) {
			//获取差值
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[]{map.get(complement), i};
			}
			//不存在该差值，存入map
			map.put(nums[i], i);
		}

		//找不到无需返回空数组
		throw new IllegalArgumentException("No two sum solution");
	}
}
