package com.winchampion.credit.pure.batch;

import java.util.concurrent.CountDownLatch;

public class MyThread extends Thread{
	private CountDownLatch countDownLatch;
	

	public MyThread(CountDownLatch countDownLatch) {
		super();
		this.countDownLatch = countDownLatch;
	}


	@Override
	public void run() {
		System.out.println("线程:" + Thread.currentThread().getName());
		Integer num = DySchedule.getLine();
		System.out.println("startline = " + (num - 1000) + ",endline = " + num);
		countDownLatch.countDown();
	}
}
