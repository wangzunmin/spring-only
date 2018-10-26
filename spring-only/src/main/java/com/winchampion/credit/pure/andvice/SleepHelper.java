package com.winchampion.credit.pure.andvice;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 通知andVice
 * @author wc
 *
 */
public class SleepHelper implements MethodBeforeAdvice,AfterReturningAdvice{
	
	Logger logger = LoggerFactory.getLogger(SleepHelper.class);
	

	/**
	 * 前置通知
	 */
	public void before(Method method, Object[] args, Object target)
			throws Throwable {
		logger.info("睡觉之前脱衣服");
	}
	
	/**
	 * 后置返回通知
	 */
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		logger.info("起床后要穿衣服");
	}


}
