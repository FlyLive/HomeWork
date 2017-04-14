package AnnotationOfColumn;

import java.lang.reflect.*;
import AnnotationOfLabel.Person;

public class PersonDisplayOfColumn implements IPersonAction {
	@Override
	public Person process(Person person) {
		// TODO Auto-generated method stub
		getPrm(person,person.getClass());
		return person;
	}
	
	public void getPrm(Object obj,Class<?> clazz){
		Field[] fields = clazz.getDeclaredFields();
		Method[] methods = clazz.getMethods();

		try {
			for (int i = 0; i < fields.length; i++) {
				String setMethod = "get" + fields[i].getName();
				for (Method method : methods) {
					if (method.getName().toLowerCase()
							.equals(setMethod.toLowerCase())) {

						getPrompt(fields[i]);

						String info = (String)method.invoke(obj).toString();
						
						System.out.println(info);
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getPrompt(Field field) {
		Column fieldColumn = field.getAnnotation(Column.class);
		System.out.print(fieldColumn.value() + ": ");
	}
}
