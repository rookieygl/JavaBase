package com.ygl.basic.collection.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/15 14:36
 * @Desc:
 */
public class GroupBy {
	public static void main(String[] args) {
		List<Map<String, String>> list = new ArrayList<>();
		Map<String, String> znameMap = new HashMap<>(100);
		Map<String, String> wnameMap = new HashMap<>(100);

		znameMap.put("surName","张");
		znameMap.put("name","四");
		znameMap.put("surName","张三");
		znameMap.put("name","四");

		wnameMap.put("surName","王");
		wnameMap.put("name","二麻子");
		list.add(znameMap);
		list.add(wnameMap);
		Map<String, List<Map<String, String>>> filter_type = list.stream().collect(Collectors.groupingBy((v) -> v.keySet().toString()));
		filter_type.forEach((surName,fullName)->{
			System.out.println(surName+fullName);
		});
	}
}
