package com.ygl.basic.interview;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/15 10:43
 * @Desc:
 */
public class FindName {
	private static String filePath = "/";

	public static void main(String[] args) {
		readNameFile();
	}

	/**
	 * 统计姓名出现的次数
	 */
	public static void readNameFile() {
		Stream<String> nameStream = null;
		try {
			//NIO读取文本
			ClassPathResource classPathResource = new ClassPathResource(filePath+"name.txt");
			nameStream = Files.lines(Paths.get(classPathResource.getURI()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//name存放map
		Map<String, Integer> nameMap = new HashMap<>(100);
		nameStream.forEach(name -> {
			String[] splitName = name.split(" ");
			String surname = splitName[0];
			if (nameMap.containsKey(surname)) {
				nameMap.put(surname, nameMap.get(surname) + 1);
				return;
			}
			nameMap.put(splitName[0], 1);
		});
		nameMap.forEach((surname, count) -> {
			System.out.println("姓: " + surname + " 出现次数: " + count);
		});
	}

}
