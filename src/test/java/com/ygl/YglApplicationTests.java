package com.ygl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URL;

@SpringBootTest
class YglApplicationTests {

	/**
	 * 目录
	 */
	@Test
	void contextLoads() {

		URL resource = this.getClass().getResource("/");
		ClassLoader classLoader = this.getClass().getClassLoader();

		URL resource1 = classLoader.getResource("");


		System.out.println(resource1.getPath());
		System.out.println(resource.getPath());

		String path = this.getClass().getClassLoader().getResource("application.yml").getPath();
		System.out.println(path);

		URL resource2 = Thread.currentThread().getContextClassLoader().getResource("");
		System.out.println(resource2.getPath());
	}

	/**
	 * 位运算取余
	 */
	@Test
	void positionCount() {
		int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i & ints.length - 1]);
		}
	}

	/**
	 * 位运算取余
	 */
	@Test
	void judgePower() {
		long x = 2^10+100;
		if ((x & (x - 1)) == 0) {
            System.out.println(true);
		}else {
            System.out.println(false);
            System.out.println(x & (x - 1));
        }
	}


}
