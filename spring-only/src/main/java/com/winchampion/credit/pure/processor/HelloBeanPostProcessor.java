package com.winchampion.credit.pure.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
/**
 * 可用来修改bean对象的BeanPostProcessor
 * @author WZM
 *
 * 2018年8月31日
 */
public class HelloBeanPostProcessor implements BeanPostProcessor,Ordered {
	private int order;
	private volatile int sum;

	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("------------postProcessBeforeInitialization" + bean.getClass().getName());
		if(bean.getClass().getName().equals("com.winchampion.credit.pure.circle.C")
				 || bean.getClass().getName().equals("com.winchampion.credit.pure.circle.B")){
			System.out.println(++ sum );
		}
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("------------postProcessAfterInitialization" + bean.getClass().toString());
		return bean;
	}
	
	
	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

}
