package com.winchampion.credit.pure.aware;

public class User2{

	String id;
	String name;
	Integer age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User2 [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	

}
