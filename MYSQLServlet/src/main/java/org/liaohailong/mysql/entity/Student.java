package org.liaohailong.mysql.entity;

public class Student {
	public int id;
	public String name;
	public int age;
	public String country;
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", country=" + country + "]";
	}
}
