package com.winchampion.credit.pure.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.winchampion.credit.pure.transaction.entity.User1;
import com.winchampion.credit.pure.transaction.entity.User2;
import com.winchampion.credit.pure.transaction.mapper.User1Mapper;
import com.winchampion.credit.pure.transaction.mapper.User2Mapper;

/**
 * PROPAGATION_REQUIRED 如果存在一个事务，则支持当前事务。如果没有事务则开启一个新的事务
 * PROPAGATION_SUPPORTS 如果存在一个事务，则支持当前事务。如果没有则以非事务的方式执行。
 * Propagation.MANDATORY 如果已经存在一个事务，支持当前事务。如果没有一个活动的事务，则抛出异常
 * PROPAGATION_REQUIRES_NEW需要使用 JtaTransactionManager作为事务管理器，它会开启一个新的事务。如果一个事务已经存在，则先将这个存在的事务挂起
 * PROPAGATION_NOT_SUPPORTED 需要使用 JtaTransactionManager作为事务管理器，总是非事务地执行，并挂起任何存在的事务
 * PROPAGATION_NEVER 总是非事务地执行，如果存在一个活动事务，则抛出异常
 * PROPAGATION_NESTED
 * @author wangzunmin
 *
 */
@Component
public class PropagationRequiredService {
	
	@Autowired
	private User1Mapper user1Mapper;
	
	@Autowired
	private User2Mapper user2Mapper;

	@Transactional(propagation = Propagation.REQUIRED)
	public void methodA() {
		User1 user1 = new User1();
		user1.setName("user11");
		user1Mapper.insert(user1);
		methodB();
//		int a=1/0;
	}

	/**
	 *  单独调用Propagation.SUPPORTS修饰的方法，会以非事务的方式执行；
	 */
	@Transactional(propagation = Propagation.SUPPORTS)
	public void methodB() {
		User2 user2 = new User2();
		user2.setName("user##33");
		user2Mapper.insert(user2);
//		int a=1/0;
	}
	
	/**
	 * 当单独调用methodC时，因为当前没有一个活动的事务，
	 * 则会抛出异常throw new IllegalTransactionStateException
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public void methodC() {
		User2 user2 = new User2();
		user2.setName("user222343");
		user2Mapper.insert(user2);
//		int a=1/0;
	}
	
	
}
