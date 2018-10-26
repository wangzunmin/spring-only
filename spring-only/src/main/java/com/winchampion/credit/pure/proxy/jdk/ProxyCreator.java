package com.winchampion.credit.pure.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * jdk方式创建代理对象
 * @author WZM
 *
 * 2018年9月3日
 */
public class ProxyCreator implements InvocationHandler {
	private Object target;

	public ProxyCreator(Object target) {
		assert target != null;
		Class<?>[] interfaces = target.getClass().getInterfaces();
		if (interfaces.length == 0) {
			throw new IllegalArgumentException(
					"target class don`t implement any interface");
		}
		this.target = target;
	}

	/**
	 * 生成代理对象
	 * @return
	 */
	public Object getProxy() {
		Class<?> clazz = target.getClass();
		// 生成代理对象
		return Proxy.newProxyInstance(clazz.getClassLoader(),
				clazz.getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method start");
		 // 调用目标方法
        Object retVal = method.invoke(target, args);
		System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method over");
		System.out.println("+===========" + retVal);
		return retVal;
	}

}
