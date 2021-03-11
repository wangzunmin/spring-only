package com.winchampion.credit.pure.aop.annoation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 注解方式aop
 * @author wangzunmin
 *
 */
@ComponentScan({"com.winchampion.credit.pure.aop.annoation"})
@Configuration
@EnableAspectJAutoProxy //支持@Aspect
public class AopConfig {

}
