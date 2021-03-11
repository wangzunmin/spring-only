package com.winchampion.credit.pure.aop.annoation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.winchampion.credit.pure.aop.annoation.service.AopDemoService;
public class AopAnnoationTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
		AopDemoService bean = context.getBean(AopDemoService.class);
		bean.test();
	}

}
