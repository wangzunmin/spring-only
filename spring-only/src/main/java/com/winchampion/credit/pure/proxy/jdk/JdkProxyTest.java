package com.winchampion.credit.pure.proxy.jdk;

public class JdkProxyTest {

	public static void main(String[] args) {
		PersonService personServiceimpl = new PersonServiceimpl();
		ProxyCreator proxyCreator = new ProxyCreator(personServiceimpl);
		PersonService proxy = (PersonService)proxyCreator.getProxy();
		System.out.println(proxy.getClass());
		proxy.savePerson(new Person());
	}
}
