package AnnotationOfLabel;

import AnnotationOfColumn.Column;

@Label("����")
public class Person {
	@Label("����")
	@Column(value = "����", maxLength = 10, minLength = 3)
	private String name;

	@Label("�Ա�")
	@Column(value = "�Ա�")
	private String sex;

	@Label("����")
	@Column(value = "����", maxLength = 3, minLength = 1, minValue = 0)
	private Integer age;

	@Label("���֤��")
	@Column(value = "���֤��", maxLength = 18, minLength = 18)
	private String idNo;

	@Label("�Ƿ��ѻ�")
	@Column(value = "�Ƿ��ѻ�",nullable=true, maxLength = 5, minLength = 4)
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

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
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
