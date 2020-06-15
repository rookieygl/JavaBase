package com.ygl.nio;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/4/16 17:20
 * @Desc:
 */
public class TraversePath {
	public static void main(String[] args) {
		//Paths.get 可以将多个字符串串连成路径 不能指定多个目录
		Path paths = null;
		try {
			paths = Paths.get(new ClassPathResource("/").getURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//LinkOption.NOFOLLOW_LINKS枚举类型，表示Files.exists不会跟进到路径中有连接的下层文件目录 可以自定义
		boolean exists = Files.exists(paths, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
		if (exists) {
			try {
				//path maxDepth 访问目录层级 SimpleFileVisitor默认文件访问方式
				Files.walkFileTree(paths, EnumSet.of(FileVisitOption.FOLLOW_LINKS), 2,new SimpleFileVisitor<Path>() {
					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
						System.out.println(file);
						//终止遍历 测试FileVisitor
						//if (file.endsWith("java")){
						//	return FileVisitResult.TERMINATE;
						//}
						return FileVisitResult.CONTINUE;
					}

				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
