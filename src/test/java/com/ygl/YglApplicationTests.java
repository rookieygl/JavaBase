package com.ygl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ygl.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@SpringBootTest(classes = YglApplication.class)
@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@Slf4j
class YglApplicationTests {

	/**
	 * 目录
	 */
	@Test
	void contextLoads() {

		URL resource = this.getClass().getResource("/");
		ClassLoader classLoader = this.getClass().getClassLoader();

		URL resource1 = classLoader.getResource("");


		System.out.println(resource1.getPath());
		System.out.println(resource.getPath());

		String path = this.getClass().getClassLoader().getResource("application.yml").getPath();
		System.out.println(path);

		URL resource2 = Thread.currentThread().getContextClassLoader().getResource("");
		System.out.println(resource2.getPath());
	}

	/**
	 * 位运算取余
	 */
	@Test
	void positionCount() {
		int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i & ints.length - 1]);
		}
	}

	/**
	 * 位运算取余
	 */
	@Test
	void judgePower() {
		long x = 2^10+100;
		if ((x & (x - 1)) == 0) {
            System.out.println(true);
		}else {
            System.out.println(false);
            System.out.println(x & (x - 1));
        }
	}

	@Test
	void mapToPo() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("/person.json");
		String stringCollect = Files.lines(Paths.get(classPathResource.getURI())).collect(Collectors.joining());
		ObjectMapper objectMapper = new ObjectMapper();

		Class<?> clazz = Class.forName("com.ygl.bean.Person");
		Class<?> utilClazz = Class.forName("com.ygl.bean.PersonnUtil");
		Object o = objectMapper.readValue(stringCollect, Class.forName("com.ygl.bean.Person"));

		//Field field = clazz.getDeclaredField("age");
		//String fieldName = field.getName();
		//String upperChar = fieldName.substring(0,1).toUpperCase();
		//String anotherStr = fieldName.substring(1);
		//String methodName = "get" + upperChar + anotherStr;

		Method getMethod = utilClazz.getMethod("printPerson",clazz);
		Parameter[] parameters = getMethod.getParameters();
		for (int i = 0; i < parameters.length; i++) {
			Class<?> type = parameters[i].getType();

			if (o.getClass().getName().equalsIgnoreCase(type.getName())){
				System.out.println(type.getName());
			}
		}



		getMethod.setAccessible(true);
		Object resultValue = getMethod.invoke(utilClazz.newInstance(),o);


		System.out.println(resultValue);
		//String fieldName = field.getName();
		//String upperChar = fieldName.substring(0,1).toUpperCase();
		//String anotherStr = fieldName.substring(1);
		//String methodName = "get" + upperChar + anotherStr;
		//Method getMethod = paramClazz.getMethod(methodName);
		//getMethod.setAccessible(true);
		//Object resultValue = getMethod.invoke(paramClazz);
	}

}
