package com.ygl.basic.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/21 11:44
 * @Desc:
 */
public class NumberCombination {
	private static int count = 0;

	private static Map<String, String> numberMap = new HashMap<>();

	/**
	 *查找数字组合
	 *
	 * @param list 原数组
	 * @param str 组合
	 */
	public static void numberComb(List<Integer> list, String str) {
		if (str != null && !str.equals("")) {
			System.out.println("第" + ++count + "个：" + str);
		}

		if (!numberMap.containsKey(str)) {
			numberMap.put(str, count + "");
		}
		//递归：元素和整个数组的组合
		for (int i = 0; i < list.size(); i++) {
			LinkedList<Integer> second = new LinkedList<>(list);
			String numC = str + second.remove(i);
			numberComb(second, numC);
		}

	}


	public static void main(String[] args) {
		////Arrays.
		int[] arr = {1, 2, 3, 4, 5, 6};
		List<Integer> numberArr =Arrays.stream( arr ).boxed().collect(Collectors.toList());
		numberComb(numberArr,"");
		System.out.println(numberMap.size());

		//String[] strings = {"1","2"};
		//Arrays.asList 不能把基本数据类型转化为列表
		//List<String> stringList = Arrays.asList(strings);
		//int[] arr = {1, 2, 3, 4, 5, 6};
		//List<int[]> ints = Arrays.asList(arr);
	}

}
