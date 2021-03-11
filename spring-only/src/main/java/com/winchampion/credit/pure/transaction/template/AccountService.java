package com.winchampion.credit.pure.transaction.template;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class AccountService {

	private AccountDao accountDao;
	private PlatformTransactionManager transactionManager;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}


	public void transfer(final String outer, final String inner, final int money) {
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setReadOnly(false);
		// 隔离级别,-1表示使用数据库默认级别
		def.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		final TransactionStatus status = transactionManager.getTransaction(def);
			try {
				accountDao.out(outer, money);
				accountDao.in(inner, money);
//				int i = 1/0;
				transactionManager.commit( status);  
			} catch (Exception e) {
				System.out.println("转账失败..................................");
				transactionManager.rollback(status);
			}
			 
//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
//		fixedThreadPool.submit(new Runnable() {
//			public void run() {
//				try {
//					accountDao.out(outer, money);
//					accountDao.in(inner, money);
//					int i = 1/0;
//					transactionManager.commit( status);  
//				} catch (Exception e) {
//					System.out.println("转账失败..................................");
//					transactionManager.rollback(status);
//				}
//				
//			}
//		});
//		
//		fixedThreadPool.shutdown();
		
	}
}
