package com.ygl.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/7/22 11:28
 * @Desc: 给定一个无序数组和一个值，计算是否存在两个数字之和是该值
 *          数组中同一个元素不能使用两遍
 */
public class LC001FindSumTwoNum {
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;

		twoSum(nums,target);
	}

	/**
	 * 获取 两数之和的值
	 * 空间复杂度O(n),时间复杂度O(n)
	 * @param nums
	 * @param target
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
		throw new IllegalArgumentException("No two sum solution");
	}
}