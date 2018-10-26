package com.winchampion.credit.pure.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
/**
 * 返回后通知
 * @author wc
 *
 */
public class MyAfterReturningAdvice implements AfterReturningAdvice {

	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		
	}

}
