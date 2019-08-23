package com.winchampion.credit.pure.batch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DySchedule {

	private static AtomicInteger line = new AtomicInteger(0);
	static ExecutorService pool = Executors.newFixedThreadPool(100);
	static CountDownLatch countDownLatch = new CountDownLatch(100);

	public static int getLine() {
		return line.addAndGet(1000);
	}

	public static void doJob() {
		for (int i = 0; i < 100; i++) {
			Thread thread = new MyThread(countDownLatch);
			pool.execute(thread);
		}
		pool.shutdown();

		try {
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("xxxx");

	}

	public static void main(String[] args) {
		DySchedule.doJob();
	}

}
