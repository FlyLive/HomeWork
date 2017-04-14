package AnnotationOfLabel;

import AnnotationOfColumn.Column;

@Label("人类")
public class Person {
	@Label("姓名")
	@Column(value = "姓名", maxLength = 10, minLength = 3)
	private String name;

	@Label("性别")
	@Column(value = "性别")
	private String sex;

	@Label("年龄")
	@Column(value = "年龄", maxLength = 3, minLength = 1, minValue = 0)
	private Integer age;

	@Label("身份证号")
	@Column(value = "身份证号", maxLength = 18, minLength = 18)
	private String idNo;

	@Label("是否已婚")
	@Column(value = "是否已婚",nullable=true, maxLength = 5, minLength = 4)
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
