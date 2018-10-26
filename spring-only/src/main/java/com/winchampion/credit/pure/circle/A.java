package com.winchampion.credit.pure.circle;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
	@Resource
	private B b;
	@Resource
	private C c;

	/*public A(B b) {//循环依赖 死循环
		super();
		this.b = b;
	}*/
	/*public void setB(B b) {
		this.b = b;
	}*/
	
	public void printA(){
		System.out.println("a------------------");
	}
	
	
}
