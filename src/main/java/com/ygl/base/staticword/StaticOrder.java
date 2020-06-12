package com.ygl.base.staticword;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/6/12 14:07
 * @Desc:
 */
public class StaticOrder {
	static {
		System.out.println("load outer class...");
	}

	//静态内部类
	static class StaticInner {
		static {
			System.out.println("load static inner class...");
		}

		static void staticInnerMethod() {
			System.out.println("static inner method...");
		}
	}

	public static void main(String[] args) {
		StaticOrder outer = new StaticOrder();      //此刻其内部类是否也会被加载？
		System.out.println("===========分割线===========");
		StaticOrder.StaticInner.staticInnerMethod();      //调用内部类的静态方法
	}
}
