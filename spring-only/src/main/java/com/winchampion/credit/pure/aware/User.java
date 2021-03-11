package com.winchampion.credit.pure.aware;

import org.springframework.beans.factory.BeanNameAware;

public class User implements BeanNameAware{

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
	public void setBeanName(String name) {
		this.id=name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	

}
