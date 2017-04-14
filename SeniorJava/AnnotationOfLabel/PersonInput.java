package AnnotationOfLabel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Scanner;

import AnnotationOfColumn.IPersonAction;

public class PersonInput implements IPersonAction {

	@Override
	public Person process(Person person) {
		// TODO Auto-generated method stub
		person = (Person) setPrm(person.getClass());
		return person;
	}

	public Object setPrm(Class<?> clazz) {
		Field[] fields = clazz.getDeclaredFields();
		Method[] methods = clazz.getMethods();
		Object person = null;

		try {
			person = clazz.newInstance();
			for (int i = 0; i < fields.length; i++) {
				String setMethod = "set" + fields[i].getName();
				for (Method method : methods) {
					if (method.getName().toLowerCase()
							.equals(setMethod.toLowerCase())) {

						String type = fields[i].getType().getSimpleName();

						getPrompt(fields[i]);

						Object args = getInput(type);

						method.invoke(person, args);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

	public void getPrompt(Field field) {
		Label fieldLabel = field.getAnnotation(Label.class);
		System.out.println(fieldLabel.value());
	}

	public Object getInput(String type) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Object input = null;

		do{
			if (type.equals("String")){
				input = bf.readLine();
				break;
			}
			else if(type.equals("Integer")){
				input = Integer.valueOf(bf.readLine());
				break;
			}
			else if(type.equals("Boolean")){
				input = Boolean.valueOf(bf.readLine());
				break;
			}
			else {
				System.out.print("类型错误,请重新输入:");
			}
		}while(true);

		return input;
	}
}