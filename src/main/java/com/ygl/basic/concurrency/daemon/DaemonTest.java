package com.ygl.basic.concurrency.daemon;

/**
 * @Author: open stack
 * @Author: ygl
 * @Date: 2020/4/7 18:08
 * @Desc:
 */
public class DaemonTest {
	public static Integer keyTime = 30;
	public static String key = "print";
	public static long threadId = 0;

	public static void main(String[] args) {
		Thread daemonPrintThread = new Thread(new DaemonPrintThread(), "业务线程");

		Thread printThread = new Thread(() -> {
			try {
				DaemonTest.threadId = Thread.currentThread().getId();
				DaemonTest.setKey(DaemonTest.key, DaemonTest.threadId, DaemonTest.keyTime);
				for (int i = 0; i < 15; i++) {
					Thread.sleep(1000);
					System.out.println("key is alived");
				}
				delKey();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "守护业务线程");

		daemonPrintThread.setDaemon(true);
		daemonPrintThread.start();
		printThread.start();
	}

	public static void setKey(String key, long threadId, Integer keyTime) {

	}

	public static void expireKey(String key, long threadId, Integer keyTime) {
		System.out.println("keyTime 刷新" + keyTime);
	}

	public static void delKey() {
		//删除key
	}


}

/**
 * while (true) 会在被守护的线程结束时自动销毁
 */
class DaemonPrintThread implements Runnable {
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(5000);
				DaemonTest.keyTime += 20;
				DaemonTest.expireKey(DaemonTest.key, DaemonTest.threadId, DaemonTest.keyTime);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}