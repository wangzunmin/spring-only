package com.winchampion.credit.pure.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * 基于java的spring容器配置
 * @author WZM
 *
 * 2018年8月29日
 */
@org.springframework.context.annotation.Configuration//相当于xml配置中的beans标签
@Import(Role.class)
public class Configuration {

	@Bean(name = "element")//相当于xml配置中的bean标签
	public Element getElement(){
		Element element = new Element();
		element.setName("tom");
		element.setSize("10");
		return element;
	}
	
}
