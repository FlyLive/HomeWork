package AnnotationOfLabel;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import AnnotationOfColumn.IPersonAction;

public class PersonDisplay implements IPersonAction {
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
		Label fieldLabel = field.getAnnotation(Label.class);
		System.out.print(fieldLabel.value() + ": ");
	}
}
