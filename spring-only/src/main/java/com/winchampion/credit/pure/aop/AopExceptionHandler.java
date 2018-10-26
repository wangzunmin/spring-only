package com.winchampion.credit.pure.aop;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
/**
 * aop捕获异常
 * @author wc
 *
 */
public class AopExceptionHandler implements ThrowsAdvice {
	
	Logger logger = LoggerFactory.getLogger(AopExceptionHandler.class);
	
	
//	public void afterThrowing(Exception ex){
//		
//	}
//	
	/**
	 * 重写afterThrowing()方法
	 * @param method 执行方法
	 * @param args 执行参数
	 * @param target 执行参数
	 * @param ex 异常
	 */
	public void afterThrowing(Method method, Object[] args, Object target, Exception ex){
		logger.info("异常产生的类名："+ target.getClass().getName());
		logger.info("异常产生的方法名：" + method.getName());
		StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        logger.error("异常信息：" + sw.toString());
	}
}
