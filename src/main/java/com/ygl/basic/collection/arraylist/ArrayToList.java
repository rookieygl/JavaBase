package com.ygl.basic.collection.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/9 15:19
 * @Desc:
 */
public class ArrayToList {

	public static void main(String[] args) {
		/*数组转list 这个相对直观*/
		/*定义一个字符串数组*/
		String[] str = new String[]{"hello", "world"};
		List<String> list = new ArrayList<String>();
		for (String string : str) {
			list.add(string);
		}
		System.out.println(list.get(0));

		//方式二：
		List<String> list2 = new ArrayList<String>(Arrays.asList(str));
		System.out.println(list2);

		//方式三
		List<String> list3 = Arrays.asList(str);
		System.out.println(list3);

		//方式四：使用Collections.addAll()
		List<String> list4 = new ArrayList<String>(str.length);
		Collections.addAll(list4, str);
		System.out.println(list4);

		//方式五：使用Stream中的Collector收集器
		//转换后的List 属于 java.util.ArrayList 能进行正常的增删查操作
		List<String> list5 = Stream.of(str).collect(Collectors.toList());
		System.out.println(list5);
	}
}
