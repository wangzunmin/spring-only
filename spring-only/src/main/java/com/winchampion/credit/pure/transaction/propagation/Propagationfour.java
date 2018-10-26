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
 * 
 * 
 * 结论：
 * 		
 * @author WZM
 *
 * 2018年9月11日
 */
@Component
public class Propagationfour {
	@Autowired
	private User1Service user1Service;
	@Autowired
	private User2Service user2Service;

	/**
	 * 
	 *  测试结果：user1数据插入成功
	 *  测试结果：user2数据插入成功
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
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
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void notransaction_required_new_exception(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.insert_require_new(user1);
        
        User2 user2=new User2();
        user2.setName("李四");
        user2Service.insert_require_new_exception(user2);
    }
}
