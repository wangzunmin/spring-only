package com.winchampion.credit.pure.aware;

import org.springframework.beans.factory.InitializingBean;
/**
 * 
  *  实现了InitializingBean的bean，afterPropertiesSet方法会被自动调用
 *
 */
public class InitializingBeanDemo implements InitializingBean {


	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean is invoked");
	}
	

}
