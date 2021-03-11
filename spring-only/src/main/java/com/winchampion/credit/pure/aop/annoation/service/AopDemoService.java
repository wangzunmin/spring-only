package com.winchampion.credit.pure.aop.annoation.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

import com.winchampion.credit.pure.aop.annoation.AspectJComponent;
/**
 * BeanFactoryAware 对beanfactory的感知
 * @author wangzunmin
 *
 */
@Component
public class AopDemoService implements BeanFactoryAware{

	private BeanFactory beanFactory;
	
	public void test() {
		System.out.println("test...");
		AspectJComponent bean = beanFactory.getBean(AspectJComponent.class);
		System.out.println(bean);
	}

	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	
}
