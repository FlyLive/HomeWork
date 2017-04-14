package Reflect;

public class Person implements IPerson {
	private String name;
	private String sex;
	private Integer age;
	private String idNo;
	private Boolean isMerried;

	public Person() {

	}

	public Person(String idNo) {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public void setIsMerried(Boolean isMerried) {
		this.isMerried = isMerried;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public String getSex() {
		// TODO Auto-generated method stub
		return this.sex;
	}

	public Integer getAge() {
		// TODO Auto-generated method stub
		return this.age;
	}

	public String getIdNo() {
		// TODO Auto-generated method stub
		return this.idNo;
	}

	public Boolean getIsMerried() {
		// TODO Auto-generated method stub
		return this.isMerried;
	}
}
