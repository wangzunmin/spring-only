package com.winchampion.credit.pure.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Client {
	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(HelloService.class); // 设置代理类的父类
		enhancer.setCallback(new HelloMethodInceptor());// 设置代理逻辑
		HelloService proxyObject = (HelloService)enhancer.create();//生成代理类对象
		System.out.println(proxyObject.getClass());
		proxyObject.sayHello();
	}
}
