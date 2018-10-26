package com.winchampion.credit.pure.proxy.aspectj;

import org.springframework.stereotype.Component;

@Component
public class App {
	public void say() {
		
		try {
			Class<?> forName = Class.forName("com.winchampion.credit.pure.proxy.aspectj.App");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("App say");
    }

}
