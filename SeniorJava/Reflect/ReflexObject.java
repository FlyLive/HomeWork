package Reflect;

import java.io.*;
import java.lang.reflect.*;

public class ReflexObject {
	private static String className = "Reflect.Person";// 加载类的路径bin//
	private static final String path = "张小平(ReflectObject).txt";

	public static void main(String agrs[]) {
		try {
			Class<?> clazz = Class.forName(className);// 加载类

			Object person = (Object) clazz.newInstance();

			initializeObject(clazz, person);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initializeObject(Class<?> clazz, Object person)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException {

		Method setMethodId = clazz.getMethod("setIdNo",String.class);
		Method getMethodId = clazz.getMethod("getIdNo");
		setMethodId.invoke(person,"5122245566");

		writeToFile("idNo=" + getMethodId.invoke(person));
		System.out.println("idNo=" + getMethodId.invoke(person));

		Method setMethodName = clazz.getMethod("setName",String.class);
		Method getMethodName = clazz.getMethod("getName");
		setMethodName.invoke(person,"张小平");

		writeToFile("name=" + getMethodName.invoke(person));
		System.out.println("name=" + getMethodName.invoke(person));

		Method setMethodAge = clazz.getMethod("setAge",Integer.class);
		Method getMethodAge = clazz.getMethod("getAge");
		setMethodAge.invoke(person,23);

		writeToFile("age=" + getMethodAge.invoke(person));
		System.out.println("age=" + getMethodAge.invoke(person));

		Method setMethodSex = clazz.getMethod("setSex",String.class);
		Method getMethodSex = clazz.getMethod("getSex");
		setMethodSex.invoke(person,"Male");

		writeToFile("sex=" + getMethodSex.invoke(person));
		System.out.println("sex=" + getMethodSex.invoke(person));

		Method setMethodIsMerried = clazz.getMethod("setIsMerried",Boolean.class);
		Method getMethodIsMerried = clazz.getMethod("getIsMerried");
		setMethodIsMerried.invoke(person,true);

		writeToFile("isMerried=" + getMethodIsMerried.invoke(person));
		System.out.println("isMerried=" + getMethodIsMerried.invoke(person));

	}

	public static void writeToFile(String text) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(path, true));
			bw.write(text);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}