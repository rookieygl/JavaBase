package com.ygl.basic.base.string;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/10 15:54
 * @Desc:
 */
public class StringTest {
	public static void main(String[] args) {
		System.out.println(reverse("a23456"));
	}

	/**
	 * 字符串反转
	 *
	 * @param originStr
	 * @return
	 */
	public static String reverse(String originStr) {
		if (originStr == null || originStr.length() <= 1) {
			return originStr;
		}
		return reverse(originStr.substring(1)) + originStr.charAt(0);
	}
}
