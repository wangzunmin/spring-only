package com.winchampion.credit.pure.aop;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;
/**
 * 引入通知
 * @author wc
 *
 */
public class MyIntroductionInterceptor implements IntroductionInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean implementsInterface(Class<?> intf) {
		// TODO Auto-generated method stub
		return false;
	}

}
