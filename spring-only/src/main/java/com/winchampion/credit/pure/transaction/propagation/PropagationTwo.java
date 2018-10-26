package com.winchampion.credit.pure.transaction.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.winchampion.credit.pure.transaction.entity.User1;
import com.winchampion.credit.pure.transaction.entity.User2;
import com.winchampion.credit.pure.transaction.service.User1Service;
import com.winchampion.credit.pure.transaction.service.User2Service;
/**
 * 外围方法开启事务控制
 * 
 * 结论：
 * 		在外围方法开启事务的情况下Propagation.REQUIRED修饰的内部方法会加入到外围方法的事务中，
 * 	所有Propagation.REQUIRED修饰的内部方法和外围方法均属于同一事务，只要一个方法回滚，整个事务均回滚
 * @author WZM
 *
 * 2018年9月11日
 */
@Component
public class PropagationTwo {
	@Autowired
	private User1Service user1Service;
	@Autowired
	private User2Service user2Service;

	/**
	 * 
	 *  测试结果：user1数据插入失败
	 *  测试结果：user2数据插入失败
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void notransaction_exception_required_required() {
		User1 user1 = new User1();
		user1.setName("张三");
		user1Service.insert(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		user2Service.insert(user2);

		throw new RuntimeException();
	}
	
	/**
	 * 
	 *  测试结果：user1数据插入失败
	 *  测试结果：user2数据插入失败
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public void notransaction_required_required_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.insert(user1);
        
        User2 user2=new User2();
        user2.setName("李四");
        user2Service.insertException(user2);
    }
}
