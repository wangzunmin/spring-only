package com.winchampion.credit.pure.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class HelloMethodInceptor implements MethodInterceptor{

	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("Before:" + method.getName());
		Object invoke = proxy.invokeSuper(obj, args);
		System.out.println("After:" + method.getName());
		return invoke;
	}

}
