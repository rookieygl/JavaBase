package com.ygl.basetype;

import java.util.Random;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/16 17:07
 * @Desc:
 */
public class RandomTest {
	public static void main(String[] args) {
		Random random = new Random();
		//带参的nextInt(int x)则会生成一个范围在0~x（不包含X）内的任意正整数
		System.out.println(random.nextInt(50));
	}
}
