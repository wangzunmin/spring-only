package com.winchampion.credit.pure.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonFactoryBean implements FactoryBean<Person> , InitializingBean{
	Logger logger = LoggerFactory.getLogger(PersonFactoryBean.class);

	private String personInfo;

	public Person getObject() throws Exception {
		logger.info("工厂创建对象................");
		Person person = new Person();
		String[] infos = personInfo.split(",");
		person.setName(infos[0]);
		person.setAge(infos[1]);
		return person;
	}

	public Class<?> getObjectType() {
		return Person.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void setPersonInfo(String personInfo) {
		this.personInfo = personInfo;
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean................执行了");
	}
	
	public void customOnitMethod(){
		System.out.println("init-method--------------执行了");
	}

}
