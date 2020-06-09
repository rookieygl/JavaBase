package com.ygl.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/12 10:56
 * @Desc:
 */
public class ReadFile {

	private static int bufSize = 1024;
    private static String filePath = "D:\\Code\\data\\1234.txt";
	// 文件编码,默认为gb2312
	private static String encode = "UTF-8";

	private static int LF = "\n".getBytes()[0];//换行符

	public static void main(String[] args) {
		try {
			RandomAccessFile accessFile = new RandomAccessFile(filePath, "r");
			FileChannel fileChannel = accessFile.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(bufSize);
			int length = 0;
			while ((length = fileChannel.read(byteBuffer )) != -1) {
				byteBuffer.clear();
				byte[] bytes = byteBuffer.array();
				System.out.println("start..............");
				String str = new String(bytes, encode);
				System.out.println(str);

			}
			byteBuffer.flip();
			fileChannel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
