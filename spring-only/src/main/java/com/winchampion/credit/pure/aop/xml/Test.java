package com.winchampion.credit.pure.aop.xml;

import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class Test {
	public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        Boy performer = (Boy) context.getBean("boy");
        performer.sing();
    }
}
