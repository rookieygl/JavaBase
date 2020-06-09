package com.ygl.nio;

import java.io.UnsupportedEncodingException;

/**
 * @Author: ydzy-report
 * @Author: ygl
 * @Date: 2020/5/12 10:51
 * @Desc:
 */
public class FileLineDataHandler implements DataProcessHandler{
	private String encode = "UTF-8";

	@Override
	public void process(byte[] data) {
		try {
			System.out.println(new String(data,encode).toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

}
