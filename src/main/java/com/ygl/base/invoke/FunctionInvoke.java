package com.ygl.base.invoke;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/6/12 16:38
 * @Desc:
 */
public class FunctionInvoke {
	public void print() {

	}

	private String invoke = "invoke";

	public void print(String txt, String txt1, Object... objects) {
		System.out.println(txt);
	}


	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.ygl.base.invoke.FunctionInvoke");
			//获取本类的所有方法，存放入数组
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println("方法名：" + method.getName());
				//获取本方法所有参数类型，存入数组
				Parameter[] parameters = method.getParameters();
				for (Parameter parameter : parameters) {
					System.out.println("参数名" + parameter.getName() + "类型" +parameter.getType());
				}
				Class<?>[] getTypeParameters = method.getParameterTypes();
				if (getTypeParameters.length == 0) {
					System.out.println("此方法无参数");
				}
				for (Class<?> class1 : getTypeParameters) {
					String parameterName = class1.getName();
					System.out.println("参数类型：" + parameterName);
				}
				System.out.println("****************************");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class test01 {
	public test01() {
		System.out.println("我是tset01");
	}

	public void t1() {
	}

	public void t2(String sss) {
	}

	public void t3(Integer integer, Boolean boo, test02 t) {
	}
}

class test02 {
}