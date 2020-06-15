package com.ygl.base.invoke;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Project: ydzy-report
 * @Author: ygl
 * @Date: 2020/6/12 16:38
 * @Desc: Java 反射
 */
public class FunctionInvoke {
	private String filed;

	public static void main(String[] args) {
		try {
			//printMethod();
			printFiled();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print(String txt) {
		System.out.println(txt);
	}


	/**
	 * java 反射时  obj.getClass() 获取的是对象初始值
	 *
	 * 动态反射只能用setter/getter方法，对对象赋值，通过对象反射取值
	 *
	 * @throws ReflectiveOperationException
	 */
	public static void printFiled() throws ReflectiveOperationException {
		FunctionInvoke functionInvoke = new FunctionInvoke();
		functionInvoke.setFiled("setset");
		//Class<?> clazz = Class.forName("com.ygl.base.invoke.FunctionInvoke");
		Class<?> clazz = functionInvoke.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			field.getName();
			field.setAccessible(true);
			Object value = field.get(clazz.newInstance());
			System.out.println(value);
			Method method = clazz.getMethod("print",String.class);
			method.invoke(clazz.newInstance(),value);
		}
	}


	public static void printMethod() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("com.ygl.base.invoke.FunctionInvoke");
		//Method print = clazz.getMethod("print");
		//System.out.println(print.getName());
		//Parameter[] parameters = print.getParameters();
		//for (int i = 0; i < parameters.length; i++) {
		//	System.out.println(parameters[i].getName());
		//}
		//获取本类的所有方法，存放入数组
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println("方法名：" + method.getName());
			//获取本方法所有参数类型，存入数组
			Parameter[] parameters = method.getParameters();
			for (Parameter parameter : parameters) {
				System.out.println("参数名" + parameter.getName() + "类型" + parameter.getType().getName());
			}
			//Class<?>[] getTypeParameters = method.getParameterTypes();
			//for (Class<?> class1 : getTypeParameters) {
			//	System.out.println("参数类型：" + class1.getName());
			//}
			System.out.println("****************************");
		}
	}


	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}

}