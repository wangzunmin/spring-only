package com.winchampion.credit.pure.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * 前置通知advice
 * @author wc
 *
 */
public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		
	}

}
