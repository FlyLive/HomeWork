package AnnotationOfColumn;

import java.io.IOException;
import java.lang.reflect.*;
import java.util.Scanner;

import AnnotationOfLabel.Person;

public class PersonInputOfColumn implements IPersonAction {
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
						getPrompt(fields[i]);

						Object args = getInput(fields[i]);

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
		Column fieldLabel = field.getAnnotation(Column.class);
		System.out.println(fieldLabel.value());
	}

	public Object getInput(Field field) throws IOException {
		Column column = field.getAnnotation(Column.class);
		boolean nullable = column.nullable();
		Object input = null;
		boolean isCorrect = true;

		while (isCorrect) {
			input = getCheckedInput(field.getType().getSimpleName());
			isCorrect = false;

			if (input == null || (input.toString()).length() == 0) {
				if (nullable) {
					isCorrect = false;
				} else {
					System.out.println("输入值不能为空，请重新输入。");
					isCorrect = true;
					continue;
				}
			} else {
				int maxlength = column.maxLength();
				int minlength = column.minLength();
				int maxvalue = column.maxValue();
				int minvalue = column.minValue();

				if (minlength != -1) {
					if ((input.toString()).length() >= minlength) {
						isCorrect = false;
					} else {
						isCorrect = true;
						System.out.println("输入值长度小于最小值，请重新输入。");
						continue;
					}
				}
				if (maxlength != -1) {
					if ((input.toString()).length() <= maxlength) {
						isCorrect = false;
					} else {
						isCorrect = true;
						System.out.println("输入值长度大于最大值，请重新输入。");
						continue;
					}
				}
				if (minvalue != -1) {
					if ((Integer) input >= minvalue) {
						isCorrect = false;
					} else {
						isCorrect = true;
						System.out.println("输入值小于最小值，请重新输入。");
						continue;
					}
				}
				if (maxvalue != -1) {
					if ((Integer) input <= maxvalue) {
						isCorrect = false;
					} else {
						isCorrect = true;
						System.out.println("输入值大于最大值，请重新输入。");
						continue;
					}
				}
			}
		}
		return input;
	}

	public static Object getCheckedInput(String type) {
		Scanner scanner = new Scanner(System.in);
		Object input = null;
		if (type.equals("String")) {
			input = scanner.nextLine();
		} else if (type.equals("Integer")) {
			try{
				input = Integer.valueOf(scanner.nextLine());
			}catch(Exception e){
				System.out.println("类型错误,请重试");
				input = getCheckedInput(type);
			}
		} else if (type.equals("Boolean")) {
			input = Boolean.valueOf(scanner.nextLine());
		}
		return input;
	}
}