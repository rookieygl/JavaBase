package com.ygl.algorithm.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Project: open sources
 * @Author: ygl
 * @Date: 2020/7/24 14:57
 * @Desc: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LC003LongestSubstring {
	public static void main(String[] args) {
		int acba = lengthOfLongestSubstringByMap("ababad");
		System.out.println(acba);
	}

	/**
	 * 滑动窗口
	 *
	 * @param s 字符串
	 * @return 最长字符串
	 */
	public static int lengthOfLongestSubstringByMap(String s) {
		if (s.length() == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<>();

		int max = 0;
		int left = 0;//滑动指针

		for (int i = 0; i < s.length(); i++) {
			//存储字符，只有当遇到相同字符才滑动窗口
			if (map.containsKey(s.charAt(i))) {
				//滑动窗口记录字符串长度
				left = Math.max(left, map.get(s.charAt(i)) + 1);
			}
			//记录字符出现位置，该位置随着遍历不断改变
			map.put(s.charAt(i), i);

			//当前字符位置和滑动窗口，能确定子串长度
			//从而获得最大子串
			max = Math.max(max, i - left + 1);
		}
		return max;
	}

	/**
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstringBySet(String s) {
		// 哈希集合，记录每个字符是否出现过
		Set<Character> occ = new HashSet<Character>();
		int n = s.length();
		// 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
		int rk = -1, ans = 0;
		for (int i = 0; i < n; ++i) {
			if (i != 0) {
				// 左指针向右移动一格，移除一个字符,set最大为所有字符。扩展：ASCII一共128个字符
				occ.remove(s.charAt(i - 1));
			}
			while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
				// 不断地移动右指针
				occ.add(s.charAt(rk + 1));
				++rk;
			}
			// 第 i 到 rk 个字符是一个极长的无重复字符子串
			ans = Math.max(ans, rk - i + 1);
		}
		return ans;
	}


}
