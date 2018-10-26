package com.winchampion.credit.pure.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CongurationTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Configuration.class);
//		Element bean = (Element)applicationContext.getBean("element");
//		System.out.println(bean.getName());
		Role bean = (Role)applicationContext.getBean("roleTests");
		bean.getRole();
	}
}
