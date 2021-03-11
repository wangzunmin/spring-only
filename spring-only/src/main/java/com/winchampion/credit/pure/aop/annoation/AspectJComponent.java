package com.winchampion.credit.pure.aop.annoation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectJComponent {
	
	@Pointcut("execution(* com.winchampion.credit.pure.aop.annoation.service.*.*(..))")
	private void anyOldTransfer() {}
	
	@Before("anyOldTransfer()")
    public void doAccessCheck() {
      System.out.println("doAccessCheck...");
    }

}
