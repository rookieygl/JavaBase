package com.ygl.basic.base.singleton;

/**
 * @USER: rookie_ygl
 * @DATE: 2020/6/13
 * @TIME: 12:33
 * @DESC: open stack
 **/

/**
 * 饿汉式 基本不会使用
 */
class HuangerSingleton {
	private static HuangerSingleton huangerSingleton = new HuangerSingleton();

	//构造方法私有化 只能通过getInstance获取
	private HuangerSingleton() {
	}

	public static HuangerSingleton getInstance() {
		return huangerSingleton;
	}

	//默认权限修饰符是default
	void getFunction() {

	}
}

/**
 * 线程安全，调用效率不高，但是能延时加载
 */
class LazySingleton {
	private static LazySingleton lazySingleton;

	private LazySingleton() {

	}

	public static synchronized LazySingleton getInstance() {
		if (lazySingleton == null) {

			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

}

//双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）
class DoubleCheckSingleton {
	//volatile 保证有序
	private volatile static DoubleCheckSingleton doubleCheckSingleton;

	private DoubleCheckSingleton() {
	}

	public static DoubleCheckSingleton getInstance() {
		if (doubleCheckSingleton == null) {
			synchronized (DoubleCheckSingleton.class) {
				if (doubleCheckSingleton == null) {
					doubleCheckSingleton = new DoubleCheckSingleton();
				}

			}
		}
		return doubleCheckSingleton;
	}
}

/**
 * 静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 */
class StaticSingleton {
	private static class StaticSingletonInstance {
		private static final StaticSingleton STATIC_SINGLETON = new StaticSingleton();
	}

	private StaticSingleton() {
	}

	public static StaticSingleton getInstance() {
		return StaticSingletonInstance.STATIC_SINGLETON;
	}

}

/**
 * 获取单例
 */
public class Singleton {
	private HuangerSingleton huangerSingleton = HuangerSingleton.getInstance();
	private StaticSingleton staticSingleton = StaticSingleton.getInstance();
}
