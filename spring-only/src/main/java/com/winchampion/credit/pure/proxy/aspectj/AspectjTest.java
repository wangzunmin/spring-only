package com.winchampion.credit.pure.proxy.aspectj;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class AspectjTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
		App app = (App) context.getBean("app");
		app.say();
	}
}
