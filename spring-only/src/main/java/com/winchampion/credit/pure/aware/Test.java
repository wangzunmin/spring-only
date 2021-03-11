package com.winchampion.credit.pure.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) throws Exception {
		ApplicationContext context 
			= new ClassPathXmlApplicationContext("classpath:spring-context2.xml");
		User user = context.getBean(User.class);
		User2 user2 = context.getBean(User2.class);
		System.out.println(user);
		System.out.println(user2);
	}

}
