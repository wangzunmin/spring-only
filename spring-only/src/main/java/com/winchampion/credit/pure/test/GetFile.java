package com.winchampion.credit.pure.test;

import java.io.IOException;
import java.net.URL;

import org.springframework.core.io.ClassPathResource;

public class GetFile {
	public static void main(String[] args) throws IOException {
		name();
	}

	public static void name() {
		ClassLoader classLoader = GetFile.class.getClassLoader();
		System.out.println(classLoader.getClass().getName());
		System.out.println(classLoader.getParent().getClass().getName());
		/**
		 * getResource()方法会去classpath下找这个文件，获取到url resource,
		 * 得到这个资源后，调用url.getFile获取到 文件 的绝对路径
		 */
		URL url = classLoader.getResource("log4j.properties");

		System.out.println(url.toString());
	}
	
	
	public static void getClassPathFile() throws IOException{
		ClassPathResource classPathResource = new ClassPathResource("log4j.properties");
		URL url = classPathResource.getURL();
		System.out.println(url.toString());
	}
}
