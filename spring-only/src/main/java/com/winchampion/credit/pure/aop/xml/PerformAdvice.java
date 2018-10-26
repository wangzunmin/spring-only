package com.winchampion.credit.pure.aop.xml;
/**
 * 通知类
 * @author wangzunmin
 *
 */
public class PerformAdvice {
	public void beforePerform() {
		System.out.println("表演之前要整理衣服");
	}

	public void afterPerform() {
		System.out.println("表演之后要行礼");
	}
}
