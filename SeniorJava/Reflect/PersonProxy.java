package Reflect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonProxy implements IPerson {
	private Person person;
	private static final String path = "张小平(PersonProxy).txt";

	public PersonProxy(Person person) {
		this.person = person;
	}

	@Override
	public void setName(String name) {
		this.person.setName(name);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String now = dateFormat.format(date);
		String info = "时间：" + now + ";方法名称：setName;参数：" + name;
		
		outputToTxt(info);
		System.out.println(info);
	}

	@Override
	public void setSex(String sex) {
		this.person.setSex(sex);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String now = dateFormat.format(date);
		String info = "时间：" + now + ";方法名称：setSex;参数：" + sex;
		
		outputToTxt(info);
		System.out.println(info);
	}

	@Override
	public void setAge(Integer age) {
		this.person.setAge(age);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String now = dateFormat.format(date);

		String info = "时间：" + now + ";方法名称：setAge;参数：" + age;
		
		outputToTxt(info);
		System.out.println(info);
	}

	@Override
	public void setIdNo(String idNo) {
		this.person.setIdNo(idNo);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String now = dateFormat.format(date);
		String info = "时间：" + now + ";方法名称：setIdNo;参数：" + idNo;
		
		outputToTxt(info);
		System.out.println(info);
	}

	@Override
	public void setIsMerried(Boolean isMerried) {
		this.person.setIsMerried(isMerried);

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String now = dateFormat.format(date);
		String info = "时间：" + now + ";方法名称：setIsMerried;参数：" + isMerried;
		
		outputToTxt(info);
		System.out.println(info);
	}
	
	private void outputToTxt(String info){
		try{
			BufferedWriter bw=new BufferedWriter(new FileWriter(path,true));
			bw.write(info);
			bw.flush();
			bw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public String getName() {
		return null;
	}

	public String getSex() {
		return null;
	}

	public Integer getAge() {
		return null;
	}

	public String getIdNo() {
		return null;
	}

	public Boolean getIsMerried() {
		return null;
	}

	public static void main(String[] args) {
		Person person = new Person();
		PersonProxy personProxy = new PersonProxy(person);

		personProxy.setName("张小平");
		personProxy.setSex("Male");
		personProxy.setAge(23);
		personProxy.setIsMerried(true);
		personProxy.setIdNo("5122245566");
	}
}