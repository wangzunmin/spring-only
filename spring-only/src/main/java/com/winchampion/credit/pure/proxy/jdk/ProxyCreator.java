package com.winchampion.credit.pure.proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * 区别静态代理:静态代理需要手动创建代理对象，n个目标对象手工创建n个代理对象
 * 而动态代理：jdk运行时通过反射动态生成代理对象
 * 
 * jdk方式创建代理对象（需要目标对象实现接口，cglib是不需要的）
 * 代理对象 = 增强代码（A,B处的处理） + 目标对象（原对象）；
 *
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
	 *  
	 * 生成代理对象
	 * @return
	 */
	public Object getProxy() {
		Class<?> clazz = target.getClass();//字节码文件生成Class<?>对象
		// 目标类和代理类都应实现相同的接口，通过接口的内部结构信息，根据以下方法生成代理对象
		return Proxy.newProxyInstance(clazz.getClassLoader(),
				clazz.getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getDeclaringClass());
			//这里就可以实现所谓的aop了
			//A：在调用目标方法前增强处理逻辑
			System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method start");
			// 调用目标方法
			Object retVal = method.invoke(target, args);
			//B:在调用目标方法后增强处理逻辑
			System.out.println(System.currentTimeMillis() + " - " + method.getName() + " method over");
			System.out.println("+===========" + retVal);
			return retVal;
	}
	
	public static Object getProxy2(final Object target2) throws Exception{
		Class<?> clazz = target2.getClass();
		//通过克隆方法以接口class创建一个新的class对象，此对象有构造器,即是代理class对象
		Class<?> proxyClass = Proxy.getProxyClass(clazz.getClassLoader(), clazz.getInterfaces());
		Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
		//代理对象proxy
		Object proxy = constructor.newInstance(new InvocationHandler() {
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("前置增强");
				Object result = method.invoke(target2, args);
				System.out.println("后置增强");
				return result;
			}
		});
		return proxy;
	}

}
