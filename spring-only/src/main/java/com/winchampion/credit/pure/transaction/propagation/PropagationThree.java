package com.winchampion.credit.pure.transaction.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.winchampion.credit.pure.transaction.entity.User1;
import com.winchampion.credit.pure.transaction.entity.User2;
import com.winchampion.credit.pure.transaction.service.User1Service;
import com.winchampion.credit.pure.transaction.service.User2Service;
/**
 * 外围方法没有开启事务控制
 * 
 * 结论：
 * 		在外围方法未开启事务的情况下Propagation.REQUIRES_NEW修饰的内部方法会新开启自己的事务，且开启的事务相互独立，互不干扰
 * @author WZM
 *
 * 2018年9月11日
 */
@Component
public class PropagationThree {
	@Autowired
	private User1Service user1Service;
	@Autowired
	private User2Service user2Service;

	/**
	 * 
	 *  测试结果：user1数据插入成功
	 *  测试结果：user2数据插入成功
	 */
	public void notransaction_exception_required_new() {
		User1 user1 = new User1();
		user1.setName("张三");
		user1Service.insert_require_new(user1);

		User2 user2 = new User2();
		user2.setName("李四");
		user2Service.insert_require_new(user2);

		throw new RuntimeException();
	}
	
	/**
	 * 
	 *  测试结果：user1数据插入成功
	 *  测试结果：user2数据插入失败
	 */
	public void notransaction_required_new_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.insert_require_new(user1);
        
        User2 user2=new User2();
        user2.setName("李四");
        user2Service.insert_require_new_exception(user2);
    }
}
