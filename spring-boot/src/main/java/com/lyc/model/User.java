package com.lyc.model;

public class User {
//	public int id;
	public String name;
	public Integer age;
//	public String password;
	
	public User(String name, int age) {
		super();
//		this.id = id;
		this.name = name;
		this.age = age;
//		this.password = password;
	}
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
	
}
