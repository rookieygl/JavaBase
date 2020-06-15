package com.ygl.nio;

import org.springframework.core.io.ClassPathResource;

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

	private static String encode = "UTF-8";

	private static int LF = "\n".getBytes()[0];//换行符

	public static void main(String[] args) {
		try {
			RandomAccessFile accessFile = new RandomAccessFile(new ClassPathResource("/name.txt").getURI().getPath(), "r");
			FileChannel fileChannel = accessFile.getChannel();
			ByteBuffer byteBuffer = ByteBuffer.allocate(bufSize);

			byteBuffer.clear();
			byte[] bytes = byteBuffer.array();
			System.out.println("start..............");
			String str = new String(bytes, encode);
			System.out.println(str);

			byteBuffer.flip();
			fileChannel.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
