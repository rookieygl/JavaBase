package com.ygl.bigData.hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;


/**
 * @Project: open sources
 * @Author: ygl
 * @Date: 2020/6/18 17:06
 * @Desc:
 */
public class Hadooptest {
	@Value("${hdfs.path}")
	private String path;
	@Value("${hdfs.username}")
	private String username;

	private static String hdfsPath;
	private static String hdfsName;
	private static final int bufferSize = 1024 * 1024 * 64;
	private ApplicationContext ctx;

	/**
	 * 获取HDFS配置信息
	 *
	 * @return
	 */
	private static Configuration getConfiguration() {
		Configuration configuration = new Configuration();
		configuration.set("fs.defaultFS", hdfsPath);
		return configuration;
	}

	public static void main(String[] args) throws Exception {
		System.setProperty("HADOOP_USER_NAME","root");
		File file = Paths.get("D:\\data\\ygldata\\mdata\\test\\rzlc\\back\\S1mme-Beijing-20190718184102-20190718184249-03160000.txt").toFile();
		Configuration configuration = new Configuration();
		configuration.addResource("core-site.xml");
		configuration.addResource("hbase-site.xml");
		configuration.set("fs.defaultFS","hdfs://rd2-svr234:9000");
		FileSystem fs = FileSystem.get(configuration);
		InputStream in = new FileInputStream(file);
		OutputStream out = fs.create(new Path("/" + file.getName()));
		IOUtils.copyBytes(in, out, 4096, true);
		System.out.println("ok");
	}
}
