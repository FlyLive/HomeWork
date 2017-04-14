package AnnotationOfAll;

import AnnotationOfLabel.Label;

public class Person {
	@Label("���֤��")
	private int idNo;
	
	@Label("����")
	private String name;

	@Label("�Ա�")
	private String sex;

	@Label("����")
	private Integer age;

	@Label("�Ƿ��ѻ�")
	private Boolean isMerried;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getIdNo() {
		return idNo;
	}

	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}

	public Boolean getIsMerried() {
		return isMerried;
	}

	public void setIsMerried(Boolean isMerried) {
		this.isMerried = isMerried;
	}

	public String toString() {

		return name + " " + sex + " " + age + " " + idNo + " " + isMerried;
	}
}
