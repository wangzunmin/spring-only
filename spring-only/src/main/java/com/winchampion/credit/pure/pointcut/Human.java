package com.winchampion.credit.pure.pointcut;
/**
 * PointCut 切入点
 * @author wc
 *
 */
public class Human implements Sleepable {

	public int sleep() {
//		int a = 1/0;
		 System.out.println("睡觉了！梦中自有颜如玉！");
		 return 1;
	}

}
