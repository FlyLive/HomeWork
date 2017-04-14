package Reflect;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PersonProxyDynamic implements InvocationHandler {
	private Object proxied;
	private static final String path = "张小平(PersonProxy).txt";

	public PersonProxyDynamic(Object proxied) {
		this.proxied = proxied;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String now = dateFormat.format(date);

		method.invoke(this.proxied, args);
		String info = "时间：" + now + ";方法名称：" + method.getName() + ";参数：" + args[0];

		outputToTxt(info);
		System.out.println(info);
		return null;
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

	public static void main(String[] args) {
		Person person = new Person();
		IPerson personProxy = (IPerson) Proxy.newProxyInstance(
				IPerson.class.getClassLoader(),
				new Class[] { IPerson.class }, new PersonProxyDynamic(
						person));

		personProxy.setName("张小平");
		personProxy.setSex("Male");
		personProxy.setAge(23);
		personProxy.setIsMerried(true);
		personProxy.setIdNo("5122245566");
	}
}
