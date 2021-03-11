package com.winchampion.credit.pure.transaction.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class BatchAddThreadDemo {
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public void testthreadInsert() {
//		int threadNum = 5;
//		List<GuessAccount> guessList = new ArrayList<GuessAccount>();
////		List<GuessAccount> guessList = getGuessList(10);
//		// 按照线程数量切割集合，5个线程则分层5份
////		List<List<GuessAccount>> splitList = ListUntils.splitListByPageNum(guessList, threadNum);
//		ExecutorService threadPool = Executors.newFixedThreadPool(threadNum);
//		long time1 = System.currentTimeMillis();
//		// 保证主线程和插入线程的先后执行顺序
//		CountDownLatch countDownLatch = new CountDownLatch(threadNum);
//		// 先在开启多线程外面，定义一个同步集合：
//		List<TransactionStatus> transactionStatuses = Collections.synchronizedList(new ArrayList<TransactionStatus>());
//		List<Boolean> flagList = Collections.synchronizedList(new ArrayList<Boolean>());
//		for (int i = 0; i < threadNum; i++) {
//			int num = i;
//			threadPool.execute(() -> {
//				// 将每个线程中的事务状态存入集合单当中
//				DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//				def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务，这样会比较安全些。
//				TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
//				transactionStatuses.add(status);
//				try {
//					List<GuessAccount> list = splitList.get(num);
//					// 批量插入数据
////					testForTransactional2(list);
//					int jk = 1 / 0;
//					// 提交事务
//					transactionManager.commit(status);
//				} catch (Exception e) {
//					flagList.add(false);
//				}
//				countDownLatch.countDown();
//			});
//		}
//		try {
//			countDownLatch.await();
//			// 异常集合中存在数据，回滚全部事务
//			if (flagList.size() > 0) {
//				for (TransactionStatus transactionStatus : transactionStatuses) {
//					transactionStatus.setRollbackOnly();
//				}
//				System.out.print("执行了回滚过程，回滚事物数据集合大小" + transactionStatuses.size());
//			}
//			long time2 = System.currentTimeMillis();
//			System.out.print("执行批量插入数据耗时" + (int) ((time2 - time1)) / 1000 + "秒");
//		} catch (InterruptedException e) {
//		}

	}
	

}
