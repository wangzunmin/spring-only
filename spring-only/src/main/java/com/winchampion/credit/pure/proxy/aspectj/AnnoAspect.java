package com.winchampion.credit.pure.proxy.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 基于Aspectj注解的Spring Aop简单实现
 * 切面类 
 * @author WZM
 *
 * 2018年8月2日
 */
@Aspect
@Component
public class AnnoAspect {
	/**
	 * Pointcut定义
	 * value = “execution(* com.winchampion.credit.pure.proxy.aspectj.App.say(..))” 指定当前Pointcut需要作用的JoinPoint
	 * 一个没有返回值的方法
	 */
	@Pointcut("execution(* com.winchampion.credit.pure.proxy.aspectj.App.say(..))")
	public void jointPoint() {	
	}

	/**
	 * 定义Advice
	 * JoinPoint连接点   子类ProceedingJoinPoint 用于环绕通知
	 * @param joinPoint
	 */
	@Before("jointPoint()")
	public void before(JoinPoint joinPoint) {
		System.out.println("AnnoAspect before say");
		Object target = joinPoint.getTarget();//获取目标对象， 即被代理的对象；
		Object this1 = joinPoint.getThis();////获取AOP生成的代理对象
		Signature signature = joinPoint.getSignature();
		System.out.println(joinPoint.getArgs());
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(joinPoint.getThis().getClass());
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println(joinPoint.toString());
	}

	@After("jointPoint()")
	public void after() {
		System.out.println("AnnoAspect after say");
	}
	
	/**
	 * ProceedingJoinPoint 环绕通知的连接点
	 * @param pjp
	 * @throws Throwable
	 */
	@Around("jointPoint()")
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		Object proceed = pjp.proceed();
	}
}
