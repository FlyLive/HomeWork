package GenerateInterface;

import java.lang.reflect.Method;

public class GenerateInterface {
	private Class person;
	private Class teacher;
	
	public GenerateInterface(){
		try {
			person = Class.forName("GenerateInterface.Person");
			teacher = Class.forName("GenerateInterface.Teacher");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String getPackageName(){
		String packageName = person.getPackage().getName();
		return packageName;
	}
	
	public void createInterface(){
		Method[] personMethods = this.person.getMethods();
		Method[] teacherMethods = this.person.getMethods();
		
		for(Method personMethod : personMethods){
			String personMethodName = personMethod.getName();
			for(Method teacherMethod : teacherMethods){
				String teacherMethodName = personMethod.getName();
				if(personMethodName == teacherMethodName){
					
				}
			}
		}
	}
	
	public static void main(String args[]){
		new GenerateInterface();
	}
}
