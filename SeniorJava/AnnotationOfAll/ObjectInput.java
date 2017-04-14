package AnnotationOfAll;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import AnnotationOfLabel.Label;

public class ObjectInput {
	// ͨ��ӳ����༰ע�ⴴ������
	public Object createObject(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		Object object = null;

		try {
			object = clazz.newInstance();
			for (int i = 0; i < fields.length; i++) {
				setField(fields[i], clazz, object);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return object;
	}

	// ��������
	public void setField(Field field, Class<?> clazz, Object obj)
			throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		Method[] methods = clazz.getMethods();
		String setMethod = "set" + field.getName();
		for (Method method : methods) {
			if (method.getName().equalsIgnoreCase(setMethod)) {
				getPrompt(field);

				Object args = getCheckedInput(field.getType().getSimpleName());

				method.invoke(obj, args);
			}
		}
	}

	// ͨ��ӳ����༰ע���޸Ķ���
	public Object modifyObject(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		Object obj = null;

		try {
			obj = clazz.newInstance();
			for (int i = 0; i < fields.length; i++) {
				if (!fields[i].getName().equals("idNo")) {
					setField(fields[i], clazz, obj);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}

	// ��ȡע�����ʾ
	public void getPrompt(Field field) {
		Label fieldLabel = field.getAnnotation(Label.class);
		System.out.println(fieldLabel.value());
	}

	// ��ȡ����У�������
	public Object getCheckedInput(String type) {
		Scanner sc = new Scanner(System.in);
		Object input = null;
		try {
			if(type.equalsIgnoreCase("int")){
				input = sc.nextInt();
			}else if (type.equalsIgnoreCase("String")) {
				input = sc.nextLine();
			} else if (type.equalsIgnoreCase("Integer")) {
				input = Integer.valueOf(sc.nextLine());
			} else if (type.equalsIgnoreCase("Boolean")) {
				String temp = sc.nextLine();
				if (!temp.equals("true") && !temp.equals("false")) {
					System.out.println("���ʹ���,������");
					input = getCheckedInput(type);
				} else {
					input = Boolean.valueOf(temp);
				}
			} else if (type.equalsIgnoreCase("double")) {
				input = Double.valueOf(sc.nextLine());
			}
		} catch (Exception e) {
			System.out.println("���ʹ���,������");
			input = getCheckedInput(type);
		}
		return input;
	}
}
