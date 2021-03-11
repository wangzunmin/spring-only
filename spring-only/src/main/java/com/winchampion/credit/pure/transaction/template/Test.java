package com.winchampion.credit.pure.transaction.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:mybatis-spring/spring-context2.xml");
        AccountService account = (AccountService) context.getBean("accountService");
        //Tom 向 Marry 转账1000
        account.transfer("Tom", "Marry", 1000);
	}
}
