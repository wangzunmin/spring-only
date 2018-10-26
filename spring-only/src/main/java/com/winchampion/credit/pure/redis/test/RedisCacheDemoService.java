package com.winchampion.credit.pure.redis.test;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class RedisCacheDemoService {

	
	/**
	 * 首先检查缓存，如果缓存没有调用方法
	 * @return
	 */
	 @Cacheable("A")
	 public String getString(){
		 System.out.println("xxxx");
		 return "xxx";
	 }
	 
	 /**
	  * 方法始终调用，并且保存返回值至缓存中
	  * @param str
	  * @return
	  */
	 @CachePut(value = "B")
	 public String saveString(String str){
		 return str;
	 }
	 
	 /**
	  * 移除缓存
	  * @param str
	  */
	 @CacheEvict("B")
	 public void removeString(String str){
		 System.out.println(str);
	 }
}
