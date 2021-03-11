package com.winchampion.credit.pure.proxy.jdk;

public class JdkProxyTest {

	public static void main(String[] args) {
		PersonService personServiceimpl = new PersonServiceimpl();
//		try {
//			ProxyCreator.getProxy2(personServiceimpl);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ProxyCreator proxyCreator = new ProxyCreator(personServiceimpl);
		PersonService proxy = (PersonService)proxyCreator.getProxy(); //生成代理对象
		System.out.println(proxy.getClass());
		proxy.savePerson(new Person());
	}
	
}
